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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview (showSystemUi = true)
@Composable
fun mostrarVentanaParametros(){

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

        Row(
            modifier = Modifier
                .padding(20.dp)
                .animateContentSize()
        ) {
            Column (
                modifier = Modifier
                    .weight(1f)
                    .padding(20.dp)
            ) {

            }
        }

        }
    }
