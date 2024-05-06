package com.example.parcial1aplicacionesmoviles.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial1aplicacionesmoviles.ui.theme.Parcial1AplicacionesMovilesTheme

@Composable
fun CrearNota(
    usuario:String,
    notas: MutableList<String>,
    //onNuevaNota: (nota:String) -> Unit
    ) {

    var Nota by remember { mutableStateOf("") }


    Column(modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(30.dp)
        ) {
            Text(
                text = "¡Bienvenido, $usuario!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp),
            )
            Icon(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = "Icon de login",
                modifier = Modifier.requiredSize(50.dp)
                )
        }

        Spacer(modifier = Modifier.padding(20.dp))

        Row(horizontalArrangement = Arrangement.Center){

            TextField(
                value = Nota,
                onValueChange = {Nota = it},
                label = { Text(text = "Ingrese la Nota")},
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(onClick = { /*TODO*/
                //onNuevaNota(Nota)
                notas.add(Nota)
                }
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Crear Nueva Nota")
            }
        }

        Spacer(modifier = Modifier.padding(20.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(items = notas){
                Card(modifier = Modifier.padding(20.dp).fillMaxWidth().wrapContentHeight().clickable{},
                    shape = MaterialTheme.shapes.medium
                    ){
                    Text(text = it,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier.padding(start = 10.dp))
                }
            }


        }


    }

}


@Preview(showBackground = true)
@Composable
fun CrearNotaPreview(){
    Parcial1AplicacionesMovilesTheme {
        CrearNota(usuario = "", notas = mutableListOf<String>())
    }
}