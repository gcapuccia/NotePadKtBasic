package com.example.parcial1aplicacionesmoviles.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.navArgument
import com.example.parcial1aplicacionesmoviles.ui.theme.Parcial1AplicacionesMovilesTheme


@Composable
fun LoginPage(
        onloginuser: (user:String) -> Unit
) {
    var user by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Login para crear notas",
            modifier = Modifier)

        TextField(
            value = user,
            onValueChange = { user = it},
            label = {Text(text = "Ingrese Usuario")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            modifier = Modifier ,
            onClick = { /*TODO*/
                if(user == "gcapucci"){
                    onloginuser(user)
                }else{

                }
            }
        ) {
            Text(text = "Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview(){
    Parcial1AplicacionesMovilesTheme {
        LoginPage(onloginuser = {})
    }
}