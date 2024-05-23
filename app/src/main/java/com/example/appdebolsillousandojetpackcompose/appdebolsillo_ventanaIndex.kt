package com.example.appdebolsillousandojetpackcompose

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController




@Composable
fun mostrarVentanaIndex(navController: NavController){

    val activity = LocalContext.current as Activity
    val abrirAlertDialogSalirApp = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        
        FloatingActionButton(onClick = {
            abrirAlertDialogSalirApp.value = true

        },
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.End)
                .padding(10.dp),
            containerColor = Color.Red) {
            
            Icon(painter = painterResource(id = com.example.appdebolsillousandojetpackcompose.R.drawable.svg_salir),
                contentDescription = "Icono salir",
                tint = Color.White,
                modifier = Modifier.padding(10.dp))
            
        }
        
        Spacer(modifier = Modifier.height(10.dp))
        
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
                    modifier=Modifier.size(80.dp),
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
                    modifier=Modifier.size(80.dp),
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
                    modifier=Modifier.size(80.dp),
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
                    modifier=Modifier.size(80.dp),
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
                    modifier=Modifier.size(80.dp),
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

        if(abrirAlertDialogSalirApp.value){
            AlertDialog(onDismissRequest = {
                abrirAlertDialogSalirApp.value = false
            },
                title = { Text(text = "¡Alerta saldrás de la aplicación!")},
                text = { Text(text = "¿Deseas salir de la app?")},
                confirmButton = {
                    Button(onClick = {
                        activity.finishAffinity()
                    }) {
                        Text(text = "Salir")
                    }
                },
                dismissButton = {
                    Button(onClick = {
                        abrirAlertDialogSalirApp.value = false
                    }) {
                        Text(text = "No")
                    }
                })
        }

    }
}