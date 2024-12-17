package com.example.mainappbooking.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.unit.dp
import com.example.mainappbooking.navigation.Screen

@Composable
fun BottomNavigationBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    NavigationBar(
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, "Home") },
            label = { Text("Home") },
            selected = currentRoute == Screen.Home.route,
            onClick = { onNavigate(Screen.Home.route) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Apartment, "Apartments") },
            label = { Text("Apartments") },
            selected = currentRoute == Screen.Apartments.route,
            onClick = { onNavigate(Screen.Apartments.route) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.House, "Houses") },
            label = { Text("Houses") },
            selected = currentRoute == Screen.Houses.route,
            onClick = { onNavigate(Screen.Houses.route) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, "Profile") },
            label = { Text("Profile") },
            selected = currentRoute == Screen.Profile.route,
            onClick = { onNavigate(Screen.Profile.route) }
        )
    }
} 