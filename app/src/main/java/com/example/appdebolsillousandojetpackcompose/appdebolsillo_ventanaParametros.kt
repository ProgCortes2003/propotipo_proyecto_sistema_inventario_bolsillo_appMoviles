package com.example.appdebolsillousandojetpackcompose

import androidx.compose.animation.animateContentSize
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun mostrarVentanaParametros(navController: NavController){

    var expandir by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Row {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.svg_parametros),
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
            Button(onClick = { navController.navigate(Rutas.rutaVentanaParametrosProductos) },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Productos",
                    fontSize = 20.sp)
            }
        }

        /*
        Card(
            colors= CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 4.dp)
                .fillMaxWidth()

        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .animateContentSize()
            ) {
                Column (
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Productos",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)

                    if(expandir) {

                        Row(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Column {

                                TextButton(onClick = {

                                    //Acciones para añadir producto

                                }) {
                                    Text(
                                        text = "Añadir un producto",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Normal
                                    )

                                    TextButton(onClick = {
                                        //Acciones para editar producto
                                    }) {
                                        Text(
                                            text = "Editar un producto"
                                        )
                                    }

                                    TextButton(onClick = {
                                        //Acciones para eliminar un producto
                                    }) {
                                        Text(
                                            text = "Eliminar un producto"
                                        )
                                    }

                                }

                            }
                        }

                    }else{
                        //No se realiza ninguna acción.
                    }
                }
                IconButton(onClick = { expandir = !expandir }) {
                    Icon(imageVector =
                    if(expandir) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Toggle para expandir."
                    )
                }
                }
            }
            */
        }

    }
