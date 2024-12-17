package com.example.mainappbooking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mainappbooking.ui.theme.MainAppBookingTheme
import com.example.mainappbooking.screens.HomeScreen
import com.example.mainappbooking.screens.SignInScreen
import com.example.mainappbooking.navigation.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainAppBookingTheme {
                val navController = rememberNavController()
                
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.SignIn.route
                    ) {
                        composable(Screen.SignIn.route) {
                            SignInScreen(
                                onNavigateToSignUp = { navController.navigate(Screen.SignUp.route) },
                                onSignIn = { email, password -> 
                                    navController.navigate(Screen.Home.route) {
                                        popUpTo(Screen.SignIn.route) { inclusive = true }
                                    }
                                }
                            )
                        }
                        
                        composable(Screen.Home.route) {
                            HomeScreen(
                                onNavigate = { route -> navController.navigate(route) },
                                onLogout = {
                                    navController.navigate(Screen.SignIn.route)
                                }
                            )
                        }
                        
                        // Add other screens here with similar pattern
                    }
                }
            }
        }
    }
}