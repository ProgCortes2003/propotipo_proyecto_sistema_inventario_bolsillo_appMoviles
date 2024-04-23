package com.example.appdebolsillousandojetpackcompose

import FirebaseAuthViewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Preview(showSystemUi = true)
@Composable
fun iniciarNavegacion() {

    val navController = rememberNavController()
    val viewModel: FirebaseAuthViewModel = FirebaseAuthViewModel()

    NavHost(navController = navController, startDestination = Rutas.rutaVentanaLogin, builder = {
        composable(Rutas.rutaVentanaLogin){
            mostrarVentanaLogin(navController, viewModel)
        }
        composable(Rutas.rutaVentanaIndex){
            mostrarVentanaIndex()
        }
        composable(Rutas.rutaVentanaRegistro){
            mostrarVentanaRegistro()
        }
    })
}