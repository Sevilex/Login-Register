package com.example.loginregester


enum class ServiceScreens {
    LoginScreen,
    RegisterScreen;

    companion object {
        fun fromRoute(route: String?): ServiceScreens = when (route?.substringBefore("/")) {
            LoginScreen.name -> LoginScreen
            RegisterScreen.name -> RegisterScreen

            null -> LoginScreen
            else -> throw IllegalArgumentException("Route $route is not recognize ")
        }
    }
}
