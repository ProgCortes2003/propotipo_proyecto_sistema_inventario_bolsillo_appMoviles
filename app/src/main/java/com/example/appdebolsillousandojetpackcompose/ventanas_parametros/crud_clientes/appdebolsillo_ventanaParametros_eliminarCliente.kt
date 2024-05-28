package com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_clientes

import android.widget.Toast
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.appdebolsillousandojetpackcompose.Rutas
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros.Cliente
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.database

@Composable
fun mostrarAlertDialogEliminarCliente(navController: NavController, clienteId:String){

    val abrirDialogAlert = remember { mutableStateOf(true) }
    val context = LocalContext.current
    val database = Firebase.database

    val nombreCliente = remember { mutableStateOf("")}
    val codigoCliente = remember { mutableStateOf("")}
    val numeroTelefonoCliente = remember { mutableStateOf("")}

    val idUsuario = FirebaseAuth.getInstance().currentUser?.uid
    val referenciaCliente = idUsuario?.let {
        database.getReference("inventario/clientes").child(it)
        .child(clienteId)
    }

    LaunchedEffect(referenciaCliente) {
        referenciaCliente?.get()?.addOnSuccessListener { snapshot ->
            val cliente = snapshot.getValue(Cliente::class.java)
            cliente?.let {
                nombreCliente.value = it.nombre
                codigoCliente.value = it.codigo
                numeroTelefonoCliente.value = it.numeroTelefono
            }
        }
    }

    if(abrirDialogAlert.value){
        AlertDialog(
            onDismissRequest = {
                abrirDialogAlert.value = false
                navController.navigate(Rutas.rutaVentanaParametrosLeerCliente)
                               },
            title={ Text(text = "¡Alerta vas a eliminar un producto: ${nombreCliente.value}!") },
            text={ Text(text = "¿Deseas eliminar este producto?") },
            confirmButton = {
                Button(onClick = {
                    referenciaCliente?.removeValue()?.addOnSuccessListener {
                        Toast.makeText(context,"¡Producto eliminado con éxito!", Toast.LENGTH_SHORT).show()
                        navController.navigate(Rutas.rutaVentanaParametrosLeerCliente)
                    }?.addOnFailureListener{
                        Toast.makeText(context,"¡Ha ocurrido un error! No ha sido posible eliminar el producto", Toast.LENGTH_SHORT).show()
                    }
                }) {
                    Text(text = "Eliminar")
                }
            },
            dismissButton = {
                Button(onClick = {
                    abrirDialogAlert.value = false
                    navController.navigate(Rutas.rutaVentanaParametrosLeerCliente)}) {
                    Text(text = "Cancelar")
                }
            })

    }


}