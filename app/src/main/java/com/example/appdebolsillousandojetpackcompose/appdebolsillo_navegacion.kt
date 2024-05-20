package com.example.appdebolsillousandojetpackcompose

import FirebaseAuthViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_productos.mostrarAlertDialogEliminarProducto
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_productos.mostrarVentanaActualizarProducto
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_productos.mostrarVentanaCrearProducto
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_productos.mostrarVentanaParametrosLeerProductos



@Composable
fun iniciarNavegacion() {

    val navController = rememberNavController()
    val viewModel: FirebaseAuthViewModel = FirebaseAuthViewModel()





    NavHost(navController = navController, startDestination = Rutas.rutaVentanaLogin, builder = {
        composable(Rutas.rutaVentanaLogin){
            mostrarVentanaLogin(navController, viewModel)
        }
        composable(Rutas.rutaVentanaIndex){
            mostrarVentanaIndex(navController)
        }
        composable(Rutas.rutaVentanaRegistro){
            mostrarVentanaRegistro(navController, viewModel)
        }
        composable(Rutas.rutaVentanaParametros){
            mostrarVentanaParametros(navController)
        }
        composable(Rutas.rutaVentanaParametrosLeerProductos){
            mostrarVentanaParametrosLeerProductos(navController)
        }
        composable(Rutas.rutaVentanaParametrosCrearProducto){
            mostrarVentanaCrearProducto(navController)
        }

        composable(Rutas.rutaVentanaParametrosActualizarProducto+"/{productoId}"){
            val productoId = it.arguments?.getString("productoId")
            mostrarVentanaActualizarProducto(navController, productoId?: "")
        }

        composable(Rutas.rutaVentanaParametrosEliminarproducto+"/{productoId}"){
            val productoId = it.arguments?.getString("productoId")
            mostrarAlertDialogEliminarProducto(navController, productoId?:"")
        }



    })
}