package com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_productos

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
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros.Producto
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.database

@Composable
fun mostrarAlertDialogEliminarProducto(navController: NavController, productoId: String){

    val abrirDialogAlert = remember { mutableStateOf(true) }
    val context = LocalContext.current
    val database = Firebase.database
    val categoriaProducto = remember { mutableStateOf("")}
    val nombreProducto = remember { mutableStateOf("")}
    val codigoProducto = remember { mutableStateOf("")}
    val valorCostoProducto = remember { mutableStateOf("")}
    val valorVentaProducto = remember { mutableStateOf("")}
    val idUsuario = FirebaseAuth.getInstance().currentUser?.uid
    val referenciaProducto = idUsuario?.let {
        database.getReference("productos").child(it)
        .child(productoId)
    }

    LaunchedEffect(referenciaProducto) {
        referenciaProducto?.get()?.addOnSuccessListener { snapshot ->
            val producto = snapshot.getValue(Producto::class.java)
            producto?.let {
                categoriaProducto.value = it.categoria
                nombreProducto.value = it.nombre
                codigoProducto.value = it.codigo
                valorCostoProducto.value = it.valorCosto.toString()
                valorVentaProducto.value = it.valorVenta.toString()
            }
        }
    }

    if(abrirDialogAlert.value){
        AlertDialog(
            onDismissRequest = {
                abrirDialogAlert.value = false
                navController.navigate(Rutas.rutaVentanaParametrosLeerProductos)
                               },
            title={ Text(text = "¡Alerta vas a eliminar un producto: ${nombreProducto.value}!") },
            text={ Text(text = "¿Deseas eliminar este producto?") },
            confirmButton = {
                Button(onClick = {
                    referenciaProducto?.removeValue()?.addOnSuccessListener {
                        Toast.makeText(context,"¡Producto eliminado con éxito!", Toast.LENGTH_SHORT).show()
                        navController.navigate(Rutas.rutaVentanaParametrosLeerProductos)
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
                    navController.navigate(Rutas.rutaVentanaParametrosLeerProductos)}) {
                    Text(text = "Cancelar")
                }
            })

    }


}