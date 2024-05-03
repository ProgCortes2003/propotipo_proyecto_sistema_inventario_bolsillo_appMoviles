package com.example.appdebolsillousandojetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



@Composable
fun mostrarVentanaIndex(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Hola de nuevo",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(40.dp))

        Image(painter= painterResource(id = R.drawable.imagen_usuario_ventana_index),
            contentDescription = "foto de perfil del usuario en la ventana index.",
            modifier= Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Nombre de la empresa",
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(text="¿Qué deseas hacer?",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row {

            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { /*TODO*/ },
                    modifier=Modifier.size(100.dp),
                    shape= CircleShape
                ) {

                    Icon(painter = painterResource(id = R.drawable.svg_entrada),
                        contentDescription = "icono para ventana entrada",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "Entrada",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(50.dp))

            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { /*TODO*/ },
                    modifier=Modifier.size(100.dp),
                    shape= CircleShape
                ) {

                    Icon(painter = painterResource(id = R.drawable.svg_salida),
                        contentDescription = "icono para ventana entrada",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "Salida",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }

        Spacer(modifier = Modifier.height(10.dp))

        Row {

            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { /*TODO*/ },
                    modifier=Modifier.size(100.dp),
                    shape= CircleShape
                ) {

                    Icon(painter = painterResource(id = R.drawable.svg_inventario),
                        contentDescription = "icono para ventana entrada",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "Inventario",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(50.dp))

            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { /*TODO*/ },
                    modifier=Modifier.size(100.dp),
                    shape= CircleShape
                ) {

                    Icon(painter = painterResource(id = R.drawable.svg_kardex),
                        contentDescription = "icono para ventana entrada",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "KARDEX",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }

        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                                 navController.navigate(Rutas.rutaVentanaParametros)
                                 },
                    modifier=Modifier.size(100.dp),
                    shape= CircleShape
                ) {

                    Icon(painter = painterResource(id = R.drawable.svg_parametros),
                        contentDescription = "icono para ventana entrada",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "Parámetros",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}