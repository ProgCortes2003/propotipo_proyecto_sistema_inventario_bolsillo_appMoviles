package com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_proveedores

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appdebolsillousandojetpackcompose.Rutas
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros.Proveedor
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.database

@Composable
fun mostrarVentanaCrearProveedor(navController: NavController){
    
    val nombreProveedor = remember { mutableStateOf("")}
    val codigoProveedor = remember { mutableStateOf("")}
    val numeroTelefonoProveedor = remember { mutableStateOf("") }
    val emailProveedor = remember { mutableStateOf("") }
    val database = Firebase.database
    val idUsuario = FirebaseAuth.getInstance().currentUser?.uid
    val referenciaBaseDeDatos = idUsuario?.let { database.getReference("proveedores").child(it) }
    val context = LocalContext.current
    
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        Text(text = "Crear Producto",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(50.dp))
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 80.dp
                )
      
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                
                OutlinedTextField(
                    value = nombreProveedor.value , 
                    onValueChange = {nombreProveedor.value = it} ,
                    label = {
                        Text(text = "Nombre")
                    })

                OutlinedTextField(
                    value = codigoProveedor.value ,
                    onValueChange = {codigoProveedor.value = it},
                    label = {
                        Text(text = "Código")
                    })

                OutlinedTextField(
                    value = numeroTelefonoProveedor.value,
                    onValueChange = {numeroTelefonoProveedor.value = it} ,
                    label = {
                        Text(text = "Número de Telefóno")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    )
                )
                
                OutlinedTextField(
                    value = emailProveedor.value , 
                    onValueChange = {emailProveedor.value = it},
                    label = {
                        Text(text = "Email")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = {
                    if(nombreProveedor.value.isNotEmpty() &&
                        codigoProveedor.value.isNotEmpty() &&
                        numeroTelefonoProveedor.value.isNotEmpty() &&
                        emailProveedor.value.isNotEmpty()){

                        val emailEsValido = Patterns.EMAIL_ADDRESS.matcher(emailProveedor.toString()).matches()
                        val telefonoEsValido = numeroTelefonoProveedor.toString().length == 10

                        if(!emailEsValido){
                            Toast.makeText(context, "¡Ingresa un email válido!",Toast.LENGTH_SHORT).show()
                        }else if(!telefonoEsValido){
                            Toast.makeText(context,"¡Ingresa un número de telefóno válido! Longitud = 10 carácteres.",Toast.LENGTH_SHORT).show()
                        }else{

                            val referenciaNuevoProducto = referenciaBaseDeDatos?.push()
                            val proveedorId = referenciaNuevoProducto?.key

                            val proveedor = Proveedor(
                                proveedorId,
                                nombreProveedor.value,
                                codigoProveedor.value,
                                numeroTelefonoProveedor.value,
                                emailProveedor.value
                            )

                            referenciaNuevoProducto?.setValue(proveedor)?.addOnSuccessListener {
                                nombreProveedor.value = ""
                                codigoProveedor.value = ""
                                numeroTelefonoProveedor.value = ""
                                emailProveedor.value = ""
                                Toast.makeText(context,"¡Datos ingresados con éxito!",Toast.LENGTH_SHORT).show()
                                Toast.makeText(context,"¡${nombreProveedor.value.uppercase()} ha sido agregado!",Toast.LENGTH_SHORT).show()
                                navController.navigate(Rutas.rutaVentanaParametrosLeerProveedores)
                            }?.addOnFailureListener{
                                Toast.makeText(context,"¡Ha ocurrido un error! Vuelve a intentarlo",Toast.LENGTH_SHORT).show()
                            }
                        }


                    }else{
                        Toast.makeText(context,"¡Debe rellenar todos los campos!", Toast.LENGTH_SHORT).show()
                    }
                }) {

                    Text(
                        text = "Crear Proveedor",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                }
               
                
            }
            
        }
        
    }
    
}