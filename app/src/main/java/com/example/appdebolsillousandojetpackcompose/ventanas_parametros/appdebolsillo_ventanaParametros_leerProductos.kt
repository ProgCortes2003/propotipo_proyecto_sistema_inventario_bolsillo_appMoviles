package com.example.appdebolsillousandojetpackcompose.ventanas_parametros

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appdebolsillousandojetpackcompose.Rutas
import com.google.firebase.Firebase
import com.google.firebase.database.database
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros.Producto
import com.google.firebase.components.Lazy
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

@Composable
fun mostrarVentanaParametrosLeerProductos(navController: NavController){

    val registros = remember { buscarTodosLosRegistrosEnBaseDeDatos()}

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        
        LazyColumn(content = {
            items(registros){
                registro ->

                Card (modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)) {
                    
                    Text(text = "Nombre del producto: ${registro.nombre}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    
                    Spacer(modifier = Modifier.height(10.dp))
                    
                    Text(text = "Categoria del producto: ${registro.categoria}")

                    Spacer(modifier = Modifier.height(10.dp))
                    
                    Text(text = "Código del producto: ${registro.codigo}")
                    
                    Spacer(modifier = Modifier.height(10.dp))
                    
                    Text(text = "Valor de costo: ${registro.valorCosto}")
                    
                    Spacer(modifier = Modifier.height(10.dp))
                    
                    Text(text = "Valor de venta: ${registro.valorVenta}")
                }
            }
        })



        FloatingActionButton(
            onClick = {
                navController.navigate(Rutas.rutaVentanaParametrosCrearProducto)
            },
            shape = CircleShape,
            containerColor = Color.Yellow,
            modifier = Modifier
                .size(80.dp)
                .padding(20.dp)
                .align(Alignment.End)
                ) {

          Icon(
              painter = painterResource(id = com.example.appdebolsillousandojetpackcompose.R.drawable.svg_aniadir_producto) ,
              contentDescription = "icono de más que denota agregar un nuevo producto",
              tint = Color.Black
          )


        }

    }

}

fun buscarTodosLosRegistrosEnBaseDeDatos():List<Producto> {
    val database = Firebase.database
    val myRef = database.getReference("Productos")

    val listaProductos = mutableListOf<Producto>()

    myRef.addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            for (data in dataSnapshot.children) {
                val categoria = data.child("categoria").getValue(String::class.java) ?: ""
                val nombre = data.child("nombre").getValue(String::class.java) ?: ""
                val codigo = data.child("codigo").getValue(String::class.java) ?: ""
                val valorCosto = data.child("valorCosto").getValue(Double::class.java) ?: 0.0
                val valorVenta = data.child("valorVenta").getValue(Double::class.java) ?: 0.0

                val producto = Producto(categoria, nombre, codigo, valorCosto, valorVenta)

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







