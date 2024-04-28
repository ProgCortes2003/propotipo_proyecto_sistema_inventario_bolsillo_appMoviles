package com.example.appdebolsillousandojetpackcompose

import FirebaseAuthViewModel
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.auth


@Composable
fun mostrarVentanaLogin(navController: NavController,
                        viewModel: FirebaseAuthViewModel = FirebaseAuthViewModel()){

    val correoElectronico = remember { mutableStateOf("") }
    val contrasenia = remember { mutableStateOf("") }
    val mensajeExcepcionEnLogin = remember { mutableStateOf("") }
    val auth = FirebaseAuth.getInstance()
    val context = LocalContext.current


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Image(painter = painterResource(id = R.drawable.imagen_hola_ventana_login),
            contentDescription = "An stick figure shaking the hand representing a hello",
            modifier = Modifier.size(150.dp))

        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "!Bienvenido a DeBolsillo App",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(text ="Ingresa tus credenciales",
            fontSize = 18.sp)

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = correoElectronico.value,
            onValueChange = {correoElectronico.value = it},
            label = {
                Text(
                    text = "Correo Electrónico"
                )
            })

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = contrasenia.value,
            onValueChange = {contrasenia.value = it},
            label = {
                Text(
                    text = "Contraseña"
                )
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(20.dp))


        Button(
            onClick = {
                mensajeExcepcionEnLogin.value = ""
                auth.signInWithEmailAndPassword(correoElectronico.value, contrasenia.value)
                    .addOnCompleteListener {
                        task -> if(task.isSuccessful){
                            Toast.makeText(context, "Autenticación Éxitosa", Toast.LENGTH_SHORT).show()
                            navController.navigate(Rutas.rutaVentanaIndex)
                            Log.d(TAG, "Autenticación éxitosa")

                        } else {
                            when(task.exception){
                                is FirebaseAuthInvalidCredentialsException -> {
                                    mensajeExcepcionEnLogin.value = "Correo electrónico o contraseña inválidos."
                                    Toast.makeText(context,"${mensajeExcepcionEnLogin.value}", Toast.LENGTH_SHORT).show()
                                }
                                is FirebaseAuthUserCollisionException -> {
                                    mensajeExcepcionEnLogin.value = "Ya existe una cuenta con este correo electrónico."
                                    Toast.makeText(context,"${mensajeExcepcionEnLogin.value}", Toast.LENGTH_SHORT).show()
                                }
                                is FirebaseAuthWeakPasswordException -> {
                                    mensajeExcepcionEnLogin.value = "La contraseña debe tener al menos 6 caracteres."
                                    Toast.makeText(context,"${mensajeExcepcionEnLogin.value}", Toast.LENGTH_SHORT).show()
                                }
                                else -> {
                                    mensajeExcepcionEnLogin.value = "0currió algo inesperado. Por favor, vuelve a ingresar tus credenciales"
                                    Toast.makeText(context,"${mensajeExcepcionEnLogin.value}", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    }


        }) {
            Text(text = "Ingresar",
                fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(Rutas.rutaVentanaIndex)
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray
            )
            ) {
            Text(text = "Ingresar como Invitado",
                fontSize = 16.sp,
                color = Color.Black)

        }

        Spacer(modifier = Modifier.height(20.dp))

        TextButton(
            onClick = {
                navController.navigate(Rutas.rutaVentanaRegistro)
            }
        ) {

            Text(text = "¿No tienes una cuenta?")

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
            modifier = Modifier
                .size(60.dp)
                .clickable {

                })
    }
}