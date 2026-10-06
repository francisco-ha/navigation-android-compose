package com.example.navigationincompose.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import com.example.navigationincompose.DetailScreen
import com.example.navigationincompose.HomeScreen
import com.example.navigationincompose.LoginScreen

//El NavigationWrapper es el encargado de tener toda la navegacion
@Composable
fun NavigationWrapper() {
    val navController = rememberNavController() //objeto encargado de gestionar la navegacion
    NavHost(navController = navController, startDestination = Login) {
        composable<Login>{
            LoginScreen(navigateToHome = { navController.navigate(Home) })
        }
        composable <Home>(deepLinks = listOf(navDeepLink { uriPattern = "https://pagina-test.dev/home" })){
            HomeScreen( navigateToDetail = {name -> navController.navigate(Detail(name = name))})
        }

        /*composable <Detail>{ backStackEntry ->
            val detail = backStackEntry.toRoute<Detail>()
            //DetailScreen(detail.name, navigateToBack = {navController.popBackStack()})
            DetailScreen(detail.name, navigateToBack = {navController.navigateUp()})
            //De la siguiente forma navegamos hasta el login borrando la pila
            /*DetailScreen(detail.name, navigateToBack = {navController.navigate(Login){
                popUpTo<Login>{inclusive=false} //con el inclusive decimos que tambien incluya o no la pantalla de navegacion
                }
            })*/
        }*/

        composable <Detail>(deepLinks = listOf(navDeepLink { uriPattern = "https://pagina-test.dev/detail/{name}"
        })){ backStackEntry ->
            val name = backStackEntry.arguments?.getString("name").orEmpty()
            DetailScreen(
                name = name,
                navigateToBack = {navController.navigateUp()}
            )
            //De la siguiente forma navegamos hasta el login borrando la pila
            /*DetailScreen(detail.name, navigateToBack = {navController.navigate(Login){
                popUpTo<Login>{inclusive=false} //con el inclusive decimos que tambien incluya o no la pantalla de navegacion
                }
            })*/
        }
    }

}
