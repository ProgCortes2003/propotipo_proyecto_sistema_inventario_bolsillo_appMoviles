package com.example.appdebolsillousandojetpackcompose.ventanas_parametros

import androidx.compose.runtime.Composable
import com.google.firebase.Firebase
import com.google.firebase.database.database

@Composable
fun mostrarVentanaParametrosProductos(){

    val database = Firebase.database
    val myRef = database.getReference("message")

    myRef.setValue("Hello, World!")
}