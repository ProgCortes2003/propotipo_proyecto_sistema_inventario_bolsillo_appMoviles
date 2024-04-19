package com.example.appdebolsillousandojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.appdebolsillousandojetpackcompose.ui.theme.AppDeBolsilloUsandoJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }

    @Composable
    fun mostrarTexto(texto:String){
        Text(text = texto)
    }


    @Composable
    fun ComponenteTexto(
        texto:String, tamanio:TextUnit, tipoDeColor:Color,
        pesoLetra:FontWeight, estiloLetra:FontStyle, alineacionTexto:TextAlign){

        Text(
            modifier = Modifier,
            text = texto,
            fontSize = tamanio,
            color = tipoDeColor,
            fontWeight = pesoLetra,
            fontStyle = estiloLetra,
            textAlign = alineacionTexto
            )
    }

    @Preview(showSystemUi = true)
    @Composable
    fun mostrarTextoPreviewEnInterfazDeUsuario(){

        mostrarTexto(
            texto = "Hola de nuevo"
        )
    }

}
