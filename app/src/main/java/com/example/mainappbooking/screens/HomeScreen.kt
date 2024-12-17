package com.example.mainappbooking.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mainappbooking.components.BottomNavigationBar

data class Property(
    val name: String,
    val location: String,
    val price: Int,
    val rating: Double,
    val isApartment: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigate: (String) -> Unit = {},
    onLogout: () -> Unit = {}
) {
    val properties = remember {
        listOf(
            Property(
                name = "Luxury Villa",
                location = "New York",
                price = 300,
                rating = 4.8,
                isApartment = false
            ),
            Property(
                name = "Modern Apartment",
                location = "Los Angeles",
                price = 200,
                rating = 4.5,
                isApartment = true
            ),
            Property(
                name = "Beach House",
                location = "Miami",
                price = 400,
                rating = 4.9,
                isApartment = false
            )
        )
    }
    
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Home",
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                actions = {
                    IconButton(onClick = onLogout) {
                        Icon(Icons.Default.Logout, contentDescription = "Logout")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(
                currentRoute = "home",
                onNavigate = onNavigate
            )
        }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(properties.size) { index ->
                PropertyCard(
                    title = properties[index].name,
                    subtitle = properties[index].location,
                    price = "$${properties[index].price}/night",
                    rating = properties[index].rating.toString(),
                    onClick = { /* Handle property click */ }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PropertyCard(
    title: String,
    subtitle: String,
    price: String,
    rating: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = price,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "★ $rating",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
} 