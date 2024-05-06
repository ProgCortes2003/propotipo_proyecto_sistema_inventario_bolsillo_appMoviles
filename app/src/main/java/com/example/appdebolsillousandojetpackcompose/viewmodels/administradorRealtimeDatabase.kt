package com.example.appdebolsillousandojetpackcompose.viewmodels

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros.Producto
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow


class administradorRealtimeDatabase {

    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference.child("productos")

    fun incluirProducto(producto:Producto){
        val llave = databaseReference.push().key
        if(llave != null){
            databaseReference.child(llave).setValue(producto)
        }
    }

    fun eliminarProducto(codigoProducto: String){
        databaseReference.child(codigoProducto).removeValue()
    }

    fun actualizarProducto(codigoProducto: String, productoActualizado:Producto){
        databaseReference.child(codigoProducto).setValue(productoActualizado)
    }




}