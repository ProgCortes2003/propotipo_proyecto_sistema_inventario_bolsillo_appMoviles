package com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros

data class Producto(
    val llave: String? = null,
    val categoria:String,
    val nombre: String,
    val codigo: String,
    val valorCosto: Double,
    val valorVenta: Double
)