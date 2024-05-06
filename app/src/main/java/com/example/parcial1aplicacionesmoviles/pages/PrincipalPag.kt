package com.example.parcial1aplicacionesmoviles.pages

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.parcial1aplicacionesmoviles.ui.theme.Parcial1AplicacionesMovilesTheme


@Composable
fun PrincipalPag(modifier: Modifier = Modifier) {

    val navHostController = rememberNavController()
    val notas = remember { mutableStateListOf<String>() }


    Scaffold(
        modifier = modifier,
        topBar = {MainTopAppBar()},//topbar y titulo
        floatingActionButton = {BotonMas(navHostController)} //Boton Flotante
    ){
            Navegacion(
                modifier = Modifier.padding(it),
                navHostController = navHostController,
                notas = notas
            )
    }

}


@Composable
fun Navegacion(
    modifier: Modifier = Modifier,
    navHostController : NavHostController,
    notas : MutableList<String>
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginPage(){
               navHostController.navigate("crear/$it")

            }
        }
        composable("crear/{user}"){
            val user = it.arguments?.getString("user") ?:""
            CrearNota(user, notas = notas)
            }
        }

    }




@Composable
fun BotonMas(navHostController: NavHostController){
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    if (currentRoute == "login") {
        FloatingActionButton(onClick = { navHostController.navigate("crear") }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Crear Nueva")
        }
    }
}



//funcion para el titulo del Scafoold y colores
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(){
    TopAppBar(title = {
            Text(text = "Note Pad, Prueba de Parcial")
    },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
}

@Preview(showBackground = true)
@Composable
fun PrincipalPagPreview() {
    Parcial1AplicacionesMovilesTheme {
        PrincipalPag()
    }
}