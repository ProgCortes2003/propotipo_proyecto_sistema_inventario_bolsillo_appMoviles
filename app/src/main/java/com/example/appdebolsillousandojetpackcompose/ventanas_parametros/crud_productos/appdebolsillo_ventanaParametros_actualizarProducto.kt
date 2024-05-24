package com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_productos

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
import androidx.compose.runtime.LaunchedEffect
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
import com.google.firebase.Firebase
import com.google.firebase.database.database
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros.Producto
import com.google.firebase.auth.FirebaseAuth

@Composable
fun mostrarVentanaActualizarProducto(navController: NavController, productoId : String){

    val categoriaProducto = remember { mutableStateOf("")}
    val nombreProducto = remember { mutableStateOf("")}
    val codigoProducto = remember { mutableStateOf("")}
    val valorCostoProducto = remember { mutableStateOf("")}
    val valorVentaProducto = remember { mutableStateOf("")}
    val idUsuario = FirebaseAuth.getInstance().currentUser?.uid
    val database = Firebase.database
    val context = LocalContext.current

    val productoReferencia = idUsuario?.let { database.getReference("productos").child(it).child(productoId) }


        LaunchedEffect(productoReferencia) {
            productoReferencia?.get()?.addOnSuccessListener { snapshot ->
                val producto = snapshot.getValue(Producto::class.java)
                producto?.let {
                    categoriaProducto.value = it.categoria
                    nombreProducto.value = it.nombre
                    codigoProducto.value = it.codigo
                    valorCostoProducto.value = it.valorCosto.toString()
                    valorVentaProducto.value = it.valorVenta.toString()
                }
            }
        }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FloatingActionButton(
            onClick = {navController.navigate(Rutas.rutaVentanaParametrosLeerProductos)},
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
            text = "Actualizar un producto",
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
                    value = categoriaProducto.value,
                    onValueChange = {categoriaProducto.value = it},
                    label = {
                        Text(text = "Categoría")
                    }
                )

                OutlinedTextField(
                    value = nombreProducto.value,
                    onValueChange = {nombreProducto.value = it},
                    label = {
                        Text(text = "Nombre del Producto")
                    }
                )

                OutlinedTextField(
                    value = codigoProducto.value,
                    onValueChange = {codigoProducto.value = it},
                    label = {
                        Text(text = "Código del producto")
                    }
                )

                OutlinedTextField(
                    value = valorCostoProducto.value,
                    onValueChange = {valorCostoProducto.value = it},
                    label = {
                        Text(text = "Valor costo producto")
                    }
                )

                OutlinedTextField(
                    value = valorVentaProducto.value,
                    onValueChange = {valorVentaProducto.value = it},
                    label = {
                        Text(text = "Valor venta producto")
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))


                Button(onClick = {
                    if(nombreProducto.value.isNotEmpty() &&
                        categoriaProducto.value.isNotEmpty() &&
                        codigoProducto.value.isNotEmpty() &&
                        valorCostoProducto.value.isNotEmpty() &&
                        valorVentaProducto.value.isNotEmpty()) {

                        val producto = Producto(
                            productoId,
                            categoriaProducto.value,
                            nombreProducto.value,
                            codigoProducto.value,
                            valorCostoProducto.value.toDouble(),
                            valorVentaProducto.value.toDouble()
                        )

                        productoReferencia?.setValue(producto)
                            ?.addOnSuccessListener {
                                Toast.makeText(context, "¡Datos actualizados con éxito!", Toast.LENGTH_SHORT).show()
                                navController.navigate(Rutas.rutaVentanaParametrosLeerProductos)
                            }
                            ?.addOnFailureListener {
                                Toast.makeText(context, "¡Ha ocurrido un error!", Toast.LENGTH_SHORT).show()
                            }

                    }else{
                        Toast.makeText(context,"¡Debe rellenar todos los campos!",Toast.LENGTH_SHORT).show()
                    }


                }) {
                    Text(text = "Actualizar Producto",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }

            }
        }
    }







}


