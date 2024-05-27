package com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros

class Proveedor {
    var proveedorId:String? = null
    var nombreProveedor:String = ""
    var proveedorNIT:String = ""
    var numeroTelefonoProveedor:String = ""
    var correoElectronicoProveedor:String = ""

    constructor(
        proveedorId: String?,
        nombreProveedor: String,
        proveedorNIT: String,
        numeroTelefonoProveedor: String,
        correoElectronicoProveedor:String
    ):this(){
        this.proveedorId = proveedorId
        this.nombreProveedor = nombreProveedor
        this.proveedorNIT = proveedorNIT
        this.numeroTelefonoProveedor = numeroTelefonoProveedor
        this.correoElectronicoProveedor = correoElectronicoProveedor
    }

    constructor()


}