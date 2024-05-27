package com.example.appdebolsillousandojetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros.Producto
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_productos.buscarTodosLosRegistrosEnBaseDeDatos
import com.google.common.collect.Table
import com.google.common.collect.Tables
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

@Composable
fun mostrarVentanaInventario(navController: NavController){

    val listaProductos = remember { buscarProductosEnBaseDeDatos() }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FloatingActionButton(
            onClick = {navController.navigate(Rutas.rutaVentanaIndex)},
            containerColor = MaterialTheme.colorScheme.errorContainer ,
            contentColor = MaterialTheme.colorScheme.onSurface,
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.Start)
                .size(70.dp)
                .padding(10.dp)
        ) {

            Icon(painter = painterResource(id = R.drawable.svg_icono_volver),
                contentDescription = "Icono devolver o retornar a la ventana anterior",
                modifier = Modifier.padding(10.dp))

        }

        Text(text = "Inventario",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)

        ) {

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Gray)
                        .padding(8.dp)
                ) {
                    Text("Nombre", fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.weight(1f))
                    Text("Precio", fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.weight(1f))
                    Text("Stock", fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.weight(1f))
                    Text("Categoría", fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.weight(1f))
                }
            }
            
            if(listaProductos.isEmpty()) {

                item{
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(text = "Aún no tienes productos agregados.",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Dirígete a parámetros -> productos para crear un nuevo producto.")
                    }
                }

            }else{

                items(listaProductos){ producto ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = if (producto.hashCode() % 2 == 0) Color.LightGray else Color.White
                            )
                            .padding(8.dp)
                    ) {
                        Text(producto.nombre, modifier = Modifier.weight(1f))
                        Text(producto.valorVenta.toString(), modifier = Modifier.weight(1f))
                        Text(producto.cantidadStock.toString(), modifier = Modifier.weight(1f))
                        Text(producto.categoria, modifier = Modifier.weight(1f))
                    }

                }

            }
        }
    }

}

fun buscarProductosEnBaseDeDatos():List<Producto> {
    val database = Firebase.database
    val idUsuario = FirebaseAuth.getInstance().currentUser?.uid
    val myRef = idUsuario?.let { database.getReference("inventario/productos").child(it) }


    val listaProductos = mutableListOf<Producto>()

    myRef?.addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            for (data in dataSnapshot.children) {
                val categoria = data.child("categoria").getValue(String::class.java) ?: ""
                val nombre = data.child("nombre").getValue(String::class.java) ?: ""
                val codigo = data.child("codigo").getValue(String::class.java) ?: ""
                val valorCosto = data.child("valorCosto").getValue(Double::class.java) ?: 0.0
                val valorVenta = data.child("valorVenta").getValue(Double::class.java) ?: 0.0
                val cantidadStock = data.child("cantidadStock").getValue(Int::class.java) ?: 0
                val productoId = data.key
                val producto = Producto(productoId, categoria,nombre, codigo, valorCosto, valorVenta, cantidadStock)


                listaProductos.add(producto)
            }
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }
    }
    )
    return listaProductos
}