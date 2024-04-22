package com.example.appdebolsillousandojetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun iniciarNavegacion() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.rutaVentanaLogin, builder = {
        composable(Rutas.rutaVentanaLogin){
            mostrarVentanaLogin(navController)
        }
        composable(Rutas.rutaVentanaIndex){
            mostrarVentanaIndex()
        }
        composable(Rutas.rutaVentanaRegistro){
            mostrarVentanaRegistro()
        }
    })
}