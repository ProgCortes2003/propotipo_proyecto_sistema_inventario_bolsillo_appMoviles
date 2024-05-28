package com.example.appdebolsillousandojetpackcompose

import FirebaseAuthViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_clientes.mostrarAlertDialogEliminarCliente
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_clientes.mostrarVentanaActualizarCliente
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_clientes.mostrarVentanaCrearCliente
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_clientes.mostrarVentanaParametrosLeerClientes
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_productos.mostrarAlertDialogEliminarProducto
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_productos.mostrarVentanaActualizarProducto
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_productos.mostrarVentanaCrearProducto
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_productos.mostrarVentanaParametrosLeerProductos
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_proveedores.mostrarAlertDialogEliminarProveedor
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_proveedores.mostrarVentanaActualizarProveedor
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_proveedores.mostrarVentanaCrearProveedor
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_proveedores.mostrarVentanaParametrosLeerProveedores


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
        composable(Rutas.rutaventanaMovimientos){
            mostrarVentanaMovimientos(navController)
        }
        composable(Rutas.rutaVentanaInventario){
            mostrarVentanaInventario(navController)
        }
        composable(Rutas.rutaVentanaKardex){
            mostrarVentanaKardex(navController)
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

        composable(Rutas.rutaVentanaParametrosLeerProveedores){
            mostrarVentanaParametrosLeerProveedores(navController)
        }

        composable(Rutas.rutaVentanaParametrosCrearProveedor){
            mostrarVentanaCrearProveedor(navController)
        }

        composable(Rutas.rutaVentanaActualizarProveedor+"/{proveedorId}"){
            val proveedorId = it.arguments?.getString("proveedorId")
            mostrarVentanaActualizarProveedor(navController, proveedorId?:"" )
        }

        composable(Rutas.rutaVentanaParametrosEliminarProveedor+"/{proveedorId}"){
            val proveedorId = it.arguments?.getString("proveedorId")
            mostrarAlertDialogEliminarProveedor(navController, proveedorId?:"")
        }

        composable(Rutas.rutaVentanaParametrosLeerCliente){
            mostrarVentanaParametrosLeerClientes(navController)
        }

        composable(Rutas.rutaVentanaParametrosCrearCliente){
            mostrarVentanaCrearCliente(navController)
        }

        composable(Rutas.rutaVentanaParametrosActualizarCliente+"/{clienteId}"){
            val clienteId = it.arguments?.getString("clienteId")
            mostrarVentanaActualizarCliente(navController, clienteId?:"" )
        }

        composable(Rutas.rutaVentanaParametrosEliminarCliente+"/{clienteId}"){
            val clienteId = it.arguments?.getString("clienteId")
            mostrarAlertDialogEliminarCliente(navController, clienteId?:"")
        }




    })
}