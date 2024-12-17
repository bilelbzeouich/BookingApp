package com.example.mainappbooking.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Houses : Screen("houses")
    object Apartments : Screen("apartments")
    object Profile : Screen("profile")
    object SignIn : Screen("signin")
    object SignUp : Screen("signup")
} 