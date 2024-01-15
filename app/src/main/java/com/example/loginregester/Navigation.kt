package com.example.loginregester

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun nextNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ServiceScreens.LoginScreen.name
    ) {
        composable(ServiceScreens.LoginScreen.name) {
            LoginForm(navController = navController)
        }
        composable(ServiceScreens.RegisterScreen.name) {
            RegisterForm(navController = navController)
        }
    }
}
