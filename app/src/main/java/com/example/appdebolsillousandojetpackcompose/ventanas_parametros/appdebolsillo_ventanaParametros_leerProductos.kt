package com.example.appdebolsillousandojetpackcompose.ventanas_parametros

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.database.database
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros.Producto

@Preview(showSystemUi = true)
@Composable
fun mostrarVentanaParametrosLeerProductos(){


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){


        FloatingActionButton(
            onClick = { /*TODO*/ },
            shape = CircleShape,
            containerColor = Color.Yellow,
            modifier = Modifier
                .size(80.dp)
                .padding(20.dp)
                .align(Alignment.End)
                ) {

          Icon(
              painter = painterResource(id = com.example.appdebolsillousandojetpackcompose.R.drawable.svg_aniadir_producto) ,
              contentDescription = "icono de más que denota agregar un nuevo producto",
              tint = Color.Black
          )

        }

    }

}

@Composable
fun listarProductos(productos: List<Producto>){

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ){

        val database = Firebase.database



    }

}

@Composable
fun mostrarItemProductos(producto:Producto){

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Categoria: ${producto.categoria}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text="Nombre del producto: ${producto.nombre}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Código del producto: ${producto.codigo}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Valor de costo: $${producto.valorCosto}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Valor de venta: $${producto.valorVenta}")
        }
    }

}