package com.example.mainappbooking.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PropertyCard(
    title: String,
    price: String,
    rating: Double,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            icon()
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = price,
                style = MaterialTheme.typography.bodyMedium
            )
            Row {
                Text(
                    text = "★ $rating",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
} 