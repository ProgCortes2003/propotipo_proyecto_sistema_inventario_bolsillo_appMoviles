package com.example.appdebolsillousandojetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview (showSystemUi = true, showBackground = true)
@Composable
fun mostrarVentanaLogin(){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Image(painter = painterResource(id = R.drawable.imagen_hola_ventana_login),
            contentDescription = "An stick figure shaking the hand representing a hello",
            modifier = Modifier.size(200.dp))

        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "!Bienvenido a DeBolsillo App",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(text ="Ingresa tus credenciales",
            fontSize = 18.sp)

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(value = "",
            onValueChange = {},
            label = {
                Text(
                    text = "Correo Electrónico"
                )
            })

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = "",
            onValueChange = {},
            label = {
                Text(
                    text = "Contraseña"
                )
            })

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
        /*Acción que se ejecutará al ser presionado*/
        }) {
            Text(text = "Ingresar",
                fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        TextButton(
            onClick = {
                /*Acción que se ejecutará al presionar el texto*/
            }
        ) {

            Text(text = "¿Olvidaste tu contraseña?")

        }

        /*Otro método para generar un texto o cualquier elemento
        * que ejecute una función al momento de
        * clickearlo es el siguiente:
        *
        * Elemento(modifier = Modifier.clickable {
        *   Acción a ejecutar.
        * })*/

        Spacer(modifier = Modifier.height(20.dp))

        Image(painter = painterResource(id = R.drawable.imagen_logo_google_ventana_login) ,
            contentDescription = "Logo de Google",
            modifier = Modifier.size(60.dp).clickable {

            })
    }
}