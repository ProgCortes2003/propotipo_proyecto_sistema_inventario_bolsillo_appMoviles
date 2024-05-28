package com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_clientes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Card
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
import com.example.appdebolsillousandojetpackcompose.R
import com.example.appdebolsillousandojetpackcompose.Rutas
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros.Cliente
import com.google.firebase.Firebase
import com.google.firebase.database.database
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros.Producto
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.auth.FirebaseAuth


@Composable
fun mostrarVentanaParametrosLeerClientes(navController: NavController){

    val registros = remember { buscarTodosLosClientesEnBaseDeDatos() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        FloatingActionButton(
            onClick = {navController.navigate(Rutas.rutaVentanaParametros)},
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

        Text(text = "Listado de Clientes",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {
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
                                text = "Nombre del cliente: ${registro.nombre}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(text = "Código del cliente: ${registro.codigo}")

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(text = "Teléfono: ${registro.numeroTelefono}")

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(text = "Id cliente: ${registro.clienteId}")


                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {

                                FloatingActionButton(
                                    onClick = {

                                        navController.navigate(Rutas.rutaVentanaParametrosActualizarCliente + "/${registro.clienteId.toString()}")

                                    },
                                    shape = CircleShape,
                                    containerColor = Color.Green,
                                    modifier = Modifier.size(50.dp)
                                ) {

                                    Icon(
                                        painter = painterResource(id = com.example.appdebolsillousandojetpackcompose.R.drawable.svg_icono_editar),
                                        contentDescription = "opción editar producto",
                                        tint = Color.White,
                                        modifier = Modifier.padding(10.dp)
                                    )

                                }

                                Spacer(modifier = Modifier.width(20.dp))

                                FloatingActionButton(
                                    onClick = {
                                              navController.navigate(Rutas.rutaVentanaParametrosEliminarCliente+"/${registro.clienteId.toString()}")

                                    },
                                    shape = CircleShape,
                                    containerColor = Color.Red,
                                    modifier = Modifier.size(50.dp)
                                ) {

                                    Icon(
                                        painter = painterResource(id = com.example.appdebolsillousandojetpackcompose.R.drawable.svg_icono_eliminar),
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
                navController.navigate(Rutas.rutaVentanaParametrosCrearCliente)
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



fun buscarTodosLosClientesEnBaseDeDatos():List<Cliente> {
    val database = Firebase.database
    val idUsuario = FirebaseAuth.getInstance().currentUser?.uid
    val myRef = idUsuario?.let { database.getReference("inventario/clientes").child(it) }


    val listaClientes = mutableListOf<Cliente>()

    myRef?.addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            for (data in dataSnapshot.children) {
                val nombreCliente = data.child("nombre").getValue(String::class.java) ?: ""
                val codigoCliente = data.child("codigo").getValue(String::class.java) ?: ""
                val numeroTelefonoCliente = data.child("numeroTelefono").getValue(String::class.java) ?: ""
                val clienteId = data.key

                val cliente = Cliente(clienteId, codigoCliente, nombreCliente, numeroTelefonoCliente)

                listaClientes.add(cliente)
            }
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }
    }
    )
    return listaClientes
}












