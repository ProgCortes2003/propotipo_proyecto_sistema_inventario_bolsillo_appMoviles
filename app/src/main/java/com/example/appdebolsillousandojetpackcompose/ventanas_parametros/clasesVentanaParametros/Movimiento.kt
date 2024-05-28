package com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros

class Movimiento {

    var idMovimiento: String? = null
    var fechaMovimiento: String = ""
    var nombreProveedorOCliente =  ""
    var tipoDeMovimiento: String = ""
    var listadoProductos: String = ""
    var totalMovimiento:Int = 0



    constructor(
                idMovimiento: String?,
                fechaMovimiento:String,
                nombreProveedorOCliente: String,
                tipoDeMovimiento: String,
                listadoProductos: String,
                totalMovimiento:Int
        ){

    }


}