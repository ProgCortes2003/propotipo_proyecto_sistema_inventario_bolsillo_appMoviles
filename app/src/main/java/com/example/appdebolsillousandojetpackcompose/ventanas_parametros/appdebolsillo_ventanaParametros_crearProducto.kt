package com.example.appdebolsillousandojetpackcompose.ventanas_parametros

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.database.database
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros.Producto
import com.example.appdebolsillousandojetpackcompose.viewmodels.administradorRealtimeDatabase



@Preview(showSystemUi = true)
@Composable
fun mostrarVentanaCrearProducto(){

    val categoriaProducto = remember { mutableStateOf("")}
    val nombreProducto = remember { mutableStateOf("")}
    val codigoProducto = remember { mutableStateOf("")}
    val valorCostoProducto = remember { mutableStateOf("")}
    val valorVentaProducto = remember { mutableStateOf("")}
    val administradorRealtimeDatabase:administradorRealtimeDatabase
    val producto = Producto()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Crear un producto",
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
                        Text(text = "Nombre del producto")
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

                    administradorRealtimeDatabase.incluirProducto()

                }) {
                    Text(text = "Crear Producto",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }



            }
        }




    }

}