package com.example.appdebolsillousandojetpackcompose.ventanas_parametros

import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.platform.LocalContext
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun mostrarVentanaParametrosLeerProductos(navController: NavController){

    val registros = remember { buscarTodosLosRegistrosEnBaseDeDatos()}
    val abrirAlertDialog = remember { mutableStateOf(false) }
    var productoIdSeleccionado by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text = "Listado de Productos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        LazyColumn {
            items(registros) { registro ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {

                        Column {

                            Text(
                                text = "Nombre del producto: ${registro.nombre}",
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

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(text = "Id producto: ${registro.productoId}")


                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {

                                FloatingActionButton(
                                    onClick = {

                                        navController.navigate(Rutas.rutaVentanaParametrosActualizarProducto + "/${registro.productoId.toString()}")

                                    },
                                    shape = CircleShape,
                                    containerColor = Color.Blue,
                                    modifier = Modifier.size(50.dp)
                                ) {

                                    Icon(
                                        painter = painterResource(id = com.example.appdebolsillousandojetpackcompose.R.drawable.svg_icono_editar_listado_producto),
                                        contentDescription = "opción editar producto",
                                        tint = Color.White,
                                        modifier = Modifier.padding(10.dp)
                                    )

                                }

                                Spacer(modifier = Modifier.width(20.dp))

                                FloatingActionButton(
                                    onClick = {
                                              navController.navigate(Rutas.rutaVentanaParametrosEliminarproducto+"/${registro.productoId.toString()}")

                                    },
                                    shape = CircleShape,
                                    containerColor = Color.Red,
                                    modifier = Modifier.size(50.dp)
                                ) {

                                    Icon(
                                        painter = painterResource(id = com.example.appdebolsillousandojetpackcompose.R.drawable.svg_icono_eliminar_producto_listado_producto),
                                        contentDescription = "opción eliminar producto",
                                        tint = Color.White,
                                        modifier = Modifier.padding(10.dp)
                                    )

                                    }



                            }

                        }


                    }


                }
            }
        }





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
              painter = painterResource(id = com.example.appdebolsillousandojetpackcompose.R.drawable.svg_aniadir) ,
              contentDescription = "icono de más que denota agregar un nuevo producto",
              tint = Color.Black,
              modifier = Modifier.padding(10.dp)
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
                val productoId = data.key
                val producto = Producto(productoId,categoria, nombre, codigo, valorCosto, valorVenta)

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










