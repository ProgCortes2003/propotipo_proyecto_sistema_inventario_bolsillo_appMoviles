package com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros

class Proveedor {
    var proveedorId:String? = null
    var nombreProveedor:String = ""
    var codigoProveedor:String = ""
    var numeroTelefonoProveedor:String = ""
    var correoElectronicoProveedor:String = ""

    constructor(
        proveedorId: String?,
        nombreProveedor: String,
        codigoProveedor: String,
        numeroTelefonoProveedor: String,
        correoElectronicoProveedor:String
    ):this(){
        this.proveedorId = proveedorId
        this.nombreProveedor = nombreProveedor
        this.codigoProveedor = codigoProveedor
        this.numeroTelefonoProveedor = numeroTelefonoProveedor
        this.correoElectronicoProveedor = correoElectronicoProveedor
    }

    constructor()


}