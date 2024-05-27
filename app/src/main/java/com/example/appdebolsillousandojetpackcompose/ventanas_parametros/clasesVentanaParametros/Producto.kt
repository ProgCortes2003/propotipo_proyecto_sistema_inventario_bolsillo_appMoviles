package com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros

class Producto() {

    var productoId: String? = null
    var categoria: String = ""
    var nombre: String = ""
    var codigo: String = ""
    var valorCosto: Double = 0.0
    var valorVenta: Double = 0.0
    var cantidadStock: Int = 0

    constructor(
        productoId: String?,
        categoria: String,
        nombre: String,
        codigo: String,
        valorCosto: Double,
        valorVenta: Double,
        cantidadStock: Int
    ) : this() {
        this.productoId = productoId
        this.categoria = categoria
        this.nombre = nombre
        this.codigo = codigo
        this.valorCosto = valorCosto
        this.valorVenta = valorVenta
        this.cantidadStock = cantidadStock
    }
}


