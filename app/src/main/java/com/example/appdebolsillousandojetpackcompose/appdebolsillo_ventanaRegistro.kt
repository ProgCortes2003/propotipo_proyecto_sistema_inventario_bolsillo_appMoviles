package com.example.appdebolsillousandojetpackcompose

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("RememberReturnType")
@Preview(showSystemUi = true)
@Composable
fun mostrarVentanaRegistro(){

    val nombreEmpresa = remember { mutableStateOf("")}
    val correoElectronicoRegistro = remember { mutableStateOf("") }
    val numeroTelefono = remember { mutableStateOf("")}
    val contraseniaRegistro = remember { mutableStateOf("")}
    val confirmacionContraseniaRegistro = remember { mutableStateOf("")}


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(
          text = "Tu administrador de inventario de confianza",
          fontSize = 16.sp,
          fontWeight = FontWeight.Light,
            textAlign = TextAlign.Start
        )
        Text(
            text = "Registrarse",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(value = nombreEmpresa.value
            , onValueChange = {nombreEmpresa.value = it},
            label = {
                Text(
                    text = "Nombre de la empresa"
                )
            }
        )

        OutlinedTextField(value = correoElectronicoRegistro.value,
            onValueChange = {correoElectronicoRegistro.value = it},
            label = {
                Text(
                    text = "Correo Electrónico"
                )
            })

        OutlinedTextField(value = numeroTelefono.value,
            onValueChange = {numeroTelefono.value = it},
            label = {
                Text(
                    text = "Número de telefono"
                )
            })

        OutlinedTextField(value = contraseniaRegistro.value,
            onValueChange = {contraseniaRegistro.value = it},
            label = {
                Text(
                    text = "Contraseña"
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        OutlinedTextField(value = confirmacionContraseniaRegistro.value,
            onValueChange = {confirmacionContraseniaRegistro.value = it},
            label = {
                Text(
                    text = "Digite nuevamente su contraseña"
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Row {

            Text(
                text = "¿Ya tienes una cuenta?",
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                modifier = Modifier.clickable {

                },
                text = "Inicia sesión",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Magenta
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 60.dp),
            onClick = {

            }) {
            Text(
                text = "Crear una cuenta",
                fontSize = 20.sp
            )
        }

    }

}