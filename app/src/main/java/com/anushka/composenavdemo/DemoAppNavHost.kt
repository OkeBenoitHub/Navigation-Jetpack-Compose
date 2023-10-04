package com.anushka.composenavdemo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun DemoAppNavHost(
    navController: NavHostController = rememberNavController()
) {

    NavHost(navController = navController, startDestination = "home_screen") {

        composable(route = "home_screen") {
            HomeScreen(
                onNavigateToSecondScreen = {
                    navController.navigate("second_screen/$it")
                }
            )
        }

        composable(
            route = "second_screen/{inputName}",
            arguments = listOf(
                navArgument("inputName") {
                    type = NavType.StringType
                }
            )
        ) {
            SecondScreen(
                textToDisplay = it.arguments?.getString("inputName").toString()
            )
        }
    }
}