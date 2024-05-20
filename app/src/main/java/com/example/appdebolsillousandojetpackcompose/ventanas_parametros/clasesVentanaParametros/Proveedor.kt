package com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros

class Proveedor {
    var proveedorId:String? = null
    var nombreProveedor:String = ""
    var codigoProveedor:String = ""

    constructor(
        proveedorId: String?,
        nombreProveedor: String,
        codigoProveedor: String
    ):this(){
        this.proveedorId = proveedorId
        this.nombreProveedor = nombreProveedor
        this.codigoProveedor = codigoProveedor
    }

    constructor()


}