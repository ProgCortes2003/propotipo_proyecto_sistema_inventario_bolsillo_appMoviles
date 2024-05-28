package com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros

class Cliente {
    var clienteId:String? = null
    var codigo:String = ""
    var nombre:String = ""
    var numeroTelefono:String = ""


    constructor(
        clienteId: String?,
        codigoCliente:String,
        nombreCliente: String,
        numeroTelefono: String
    ):this(){
        this.clienteId = clienteId
        this.codigo = codigoCliente
        this.nombre = nombreCliente
        this.numeroTelefono = numeroTelefono
    }

    constructor()

}