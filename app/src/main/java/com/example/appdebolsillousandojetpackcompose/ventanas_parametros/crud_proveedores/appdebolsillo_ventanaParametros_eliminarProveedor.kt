package com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_proveedores

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
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros.Proveedor
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.database


@Composable
fun mostrarAlertDialogEliminarProveedor(navController: NavController, idProveedor:String){

    val abrirDialogAlert = remember { mutableStateOf(true) }
    val context = LocalContext.current
    val nombreProveedor = remember { mutableStateOf("") }
    val codigoProveedor = remember { mutableStateOf("") }
    val numeroTelefonoProveedor = remember { mutableStateOf("") }
    val emailProveedor = remember { mutableStateOf("") }
    val idUsuario = FirebaseAuth.getInstance().currentUser?.uid
    val baseDeDatos = Firebase.database
    val referenciaAProveedor = idUsuario?.let { baseDeDatos.getReference("proveedores").child(it).child(idProveedor) }

    LaunchedEffect(referenciaAProveedor) {

        referenciaAProveedor?.get()?.addOnSuccessListener { snapshot ->
            val proveedor = snapshot.getValue(Proveedor::class.java)
            proveedor?.let {
                nombreProveedor.value = it.nombreProveedor
                codigoProveedor.value = it.codigoProveedor
                numeroTelefonoProveedor.value = it.numeroTelefonoProveedor
                emailProveedor.value = it.correoElectronicoProveedor
            }
        }

    }

    if(abrirDialogAlert.value){
        AlertDialog(
            onDismissRequest = {
                abrirDialogAlert.value = false
                navController.navigate(Rutas.rutaVentanaParametrosLeerProveedores)
            },
            title={ Text(text = "¡Alerta vas a eliminar un producto: ${nombreProveedor.value.toString().uppercase()}!") },
            text={ Text(text = "¿Deseas eliminar este producto?") },
            confirmButton = {
                Button(onClick = {
                    referenciaAProveedor?.removeValue()?.addOnSuccessListener {
                        Toast.makeText(context,"¡Producto eliminado con éxito!", Toast.LENGTH_SHORT).show()
                        navController.navigate(Rutas.rutaVentanaParametrosLeerProveedores)
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
                    navController.navigate(Rutas.rutaVentanaParametrosLeerProveedores)}) {
                    Text(text = "Cancelar")
                }
            })

    }

}