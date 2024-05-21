package com.example.appdebolsillousandojetpackcompose


import android.graphics.Color
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun mostrarVentanaParametros(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        FloatingActionButton(
            onClick = {navController.navigate(Rutas.rutaVentanaIndex)},
            containerColor = MaterialTheme.colorScheme.errorContainer ,
            contentColor = MaterialTheme.colorScheme.onSurface,
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.Start)
                .size(70.dp)
                .padding(10.dp)
        ) {

            Icon(painter = painterResource(id = com.example.appdebolsillousandojetpackcompose.R.drawable.svg_icono_volver),
                contentDescription = "Icono devolver o retornar a la ventana anterior",
                modifier = Modifier.padding(10.dp))

        }

        Row {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = com.example.appdebolsillousandojetpackcompose.R.drawable.svg_parametros),
                    contentDescription = "Icono de la ventana parámetros.",
                    modifier = Modifier.size(100.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Parámetros",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                    )
            }
        }

        Spacer(modifier = Modifier.height(80.dp))

        Column (
            modifier = Modifier.padding(horizontal = 40.dp)
        ) {
            Button(onClick = { navController.navigate(Rutas.rutaVentanaParametrosLeerProductos) },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Productos",
                    fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { navController.navigate(Rutas.rutaVentanaParametrosLeerProveedores)},
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Proveedores",
                    fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "PQRS",
                    fontSize = 20.sp)
            }

        }


        }

    }
