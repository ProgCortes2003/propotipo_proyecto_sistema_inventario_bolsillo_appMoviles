package com.example.appdebolsillousandojetpackcompose.ventanas_parametros

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.database.database

@Preview(showSystemUi = true)
@Composable
fun mostrarVentanaParametrosLeerProductos(){


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        LazyColumn{

            val database = Firebase.database
            val myRef = database.getReference("message")

            myRef.setValue("¡Base de datos funcionando dentro de lazy column!")

        }

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