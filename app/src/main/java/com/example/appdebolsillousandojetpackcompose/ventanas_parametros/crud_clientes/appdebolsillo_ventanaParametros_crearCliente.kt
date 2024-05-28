package com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_clientes

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appdebolsillousandojetpackcompose.R
import com.example.appdebolsillousandojetpackcompose.Rutas
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros.Cliente
import com.google.firebase.Firebase
import com.google.firebase.database.database
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros.Producto
import com.google.firebase.auth.FirebaseAuth

@Composable
fun mostrarVentanaCrearCliente(navController: NavController){

    val nombreCliente = remember { mutableStateOf("")}
    val codigoCliente = remember { mutableStateOf("")}
    val numeroTelefonoCliente = remember { mutableStateOf("")}

    val database = Firebase.database
    val idUsuario = FirebaseAuth.getInstance().currentUser?.uid
    val myRef = idUsuario?.let { database.getReference("inventario/clientes").child(it) }
    val context = LocalContext.current


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FloatingActionButton(
            onClick = {navController.navigateUp()},
            containerColor = MaterialTheme.colorScheme.errorContainer ,
            contentColor = MaterialTheme.colorScheme.onSurface,
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.Start)
                .size(70.dp)
                .padding(10.dp)
        ) {

            Icon(painter = painterResource(id = R.drawable.svg_icono_volver),
                contentDescription = "Icono devolver o retornar a la ventana anterior",
                modifier = Modifier.padding(10.dp))

        }


        Text(
            text = "Crear un Cliente",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(50.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 80.dp
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(
                    value = nombreCliente.value,
                    onValueChange = {nombreCliente.value = it},
                    label = {
                        Text(text = "Nombre del cliente")
                    }
                    )

                OutlinedTextField(
                    value = codigoCliente.value,
                    onValueChange = {codigoCliente.value = it},
                    label = {
                        Text(text = "Código del cliente")
                    }
                )

                OutlinedTextField(
                    value = numeroTelefonoCliente.value,
                    onValueChange = {numeroTelefonoCliente.value = it},
                    label = {
                        Text(text = "Número de Teléfono")
                    }
                )


                Spacer(modifier = Modifier.height(20.dp))


                Button(onClick = {
                    if(nombreCliente.value.isNotEmpty() &&
                        codigoCliente.value.isNotEmpty() &&
                        numeroTelefonoCliente.value.isNotEmpty()) {

                        val newProductRef = myRef?.push()
                        val clienteId = newProductRef?.key

                        val cliente = Cliente(
                            clienteId,
                            codigoCliente.value,
                            nombreCliente.value,
                            numeroTelefonoCliente.value)


                        newProductRef?.setValue(cliente)?.addOnSuccessListener {
                            nombreCliente.value = ""
                            codigoCliente.value = ""
                            numeroTelefonoCliente.value = ""
                            Toast.makeText(context,"¡Datos ingresados con éxito!",Toast.LENGTH_SHORT).show()
                            Toast.makeText(context,"¡Identificacion del cliente generado: ${clienteId}",Toast.LENGTH_SHORT).show()
                            navController.navigate(Rutas.rutaVentanaParametrosLeerCliente)
                        }?.addOnFailureListener {
                            Toast.makeText(context,"¡Ha ocurrido un error!",Toast.LENGTH_SHORT).show()
                        }


                    }else{
                        Toast.makeText(context,"¡Debe rellenar todos los campos!",Toast.LENGTH_SHORT).show()
                    }


                }) {
                    Text(text = "Crear Cliente",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }

            }
        }
    }

}


