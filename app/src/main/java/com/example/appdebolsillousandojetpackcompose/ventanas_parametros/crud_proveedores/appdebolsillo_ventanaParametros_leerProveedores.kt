package com.example.appdebolsillousandojetpackcompose.ventanas_parametros.crud_proveedores


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
import com.example.appdebolsillousandojetpackcompose.ventanas_parametros.clasesVentanaParametros.Proveedor
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

@Composable
fun mostrarVentanaParametrosLeerProveedores(navController: NavController){
    
    val registrosProveedores = remember {
        buscarTodosLosRegistrosDeProveedoresEnBaseDeDatos()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        FloatingActionButton(
            onClick = {navController.navigate(Rutas.rutaVentanaParametros)},
            containerColor = MaterialTheme.colorScheme.errorContainer ,
            contentColor = MaterialTheme.colorScheme.onSurface,
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.Start)
                .size(100.dp)
                .padding(10.dp)
        ) {

            Icon(painter = painterResource(id = R.drawable.svg_icono_volver),
                contentDescription = "Icono devolver o retornar a la ventana anterior",
                modifier = Modifier.padding(10.dp))

        }

        Text(text = "Listado de Proveedores",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        
        LazyColumn {
            
            items(registrosProveedores){
                
                registroProveedor -> 
                
                Card (
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
                            
                            Text(text = "Nombre del Proveedor: ${registroProveedor.nombreProveedor.uppercase()}")

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(text = "Código: ${registroProveedor.codigoProveedor.uppercase()}")

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(text = "Teléfono: ${registroProveedor.numeroTelefonoProveedor}")

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(text = "Email: ${registroProveedor.correoElectronicoProveedor.uppercase()}")

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(text = "Id: ${registroProveedor.proveedorId}")

                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                                horizontalArrangement = Arrangement.Center
                            ){
                                FloatingActionButton(
                                    onClick = {
                                              navController.navigate(Rutas.rutaVentanaActualizarProveedor+"/${registroProveedor.proveedorId.toString()}")
                                              },
                                    shape = CircleShape,
                                    containerColor = Color.Blue,
                                    modifier = Modifier.size(50.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(id = com.example.appdebolsillousandojetpackcompose.R.drawable.svg_icono_editar),
                                        contentDescription = "Icono de lápiz que representa editar",
                                        tint = Color.White,
                                        modifier = Modifier.padding(10.dp)
                                        )
                                }

                                FloatingActionButton(
                                    onClick = {
                                              navController.navigate(Rutas.rutaVentanaParametrosEliminarProveedor+"/${registroProveedor.proveedorId.toString()}")
                                              },
                                    shape = CircleShape,
                                    containerColor = Color.Red,
                                    modifier = Modifier.size(50.dp)) {

                                    Icon(
                                        painter = painterResource(id = com.example.appdebolsillousandojetpackcompose.R.drawable.svg_icono_eliminar) ,
                                        contentDescription = "Icono de bote de basura que representa eliminar",
                                        tint = Color.White,
                                        modifier = Modifier.size(10.dp)
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
            navController.navigate(Rutas.rutaVentanaParametrosCrearProveedor)
        },
            shape = CircleShape,
            containerColor = Color.Yellow,
            modifier = Modifier.size(50.dp)
            ) {

            Icon(
                painter = painterResource(id = com.example.appdebolsillousandojetpackcompose.R.drawable.svg_aniadir),
                contentDescription = "Icono de plus que significa añadir",
                tint = Color.Black,
                modifier = Modifier.padding(10.dp)
            )

        }
        
    }
    
}

fun buscarTodosLosRegistrosDeProveedoresEnBaseDeDatos():List<Proveedor> {
    val database = Firebase.database
    val idUsuario = FirebaseAuth.getInstance().currentUser?.uid
    val myRef = idUsuario?.let { database.getReference("proveedores").child(it) }


    val listaProveedores = mutableListOf<Proveedor>()

    myRef?.addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            for (data in dataSnapshot.children) {
                val proveedorId = data.key
                val nombreProveedor = data.child("nombre").getValue(String::class.java) ?: ""
                val codigoProveedor = data.child("codigo").getValue(String::class.java) ?: ""
                val numeroTelefonoProveedor = data.child("numeroTelefono").getValue(String::class.java) ?: ""
                val emailProveedor = data.child("correoElectronico").getValue(String::class.java) ?: ""
                val proveedor = Proveedor(proveedorId,nombreProveedor,codigoProveedor,numeroTelefonoProveedor,emailProveedor)

                listaProveedores.add(proveedor)
            }
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }
    }
    )
    return listaProveedores
}