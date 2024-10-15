package com.example.notify.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

@Composable
fun MyColorPicker(selectedColor: Color, onColorSelected: (Color) -> Unit) {
    // Colors List
    val colorsList = listOf(
        Color("#FF5733".toColorInt()), // Vibrant Orange
        Color("#FF0000".toColorInt()), // Bright Red
        Color("#FF4500".toColorInt()), // Orange Red
        Color("#33FF57".toColorInt()), // Bright Green
        Color("#00FF00".toColorInt()), // Pure Green
        Color("#228B22".toColorInt()), // Forest Green
        Color("#3357FF".toColorInt()), // Bright Blue
        Color("#0000FF".toColorInt()), // Pure Blue
        Color("#1E90FF".toColorInt()), // Dodger Blue
        Color("#F1C40F".toColorInt()), // Sunflower Yellow
        Color("#8E44AD".toColorInt()), // Purple
        Color("#E67E22".toColorInt()), // Carrot Orange
        Color("#3498DB".toColorInt()), // Sky Blue
        Color("#2ECC71".toColorInt()), // Emerald Green
        Color("#1ABC9C".toColorInt()), // Turquoise
        Color("#9B59B6".toColorInt()), // Amethyst
        Color("#2980B9".toColorInt()), // Strong Blue
        Color("#16A085".toColorInt())  // Teal
    )

    LazyRow(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth().padding(7.dp)
    ) {
        items(colorsList) { color ->
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(color = color) // Background for color picker
                    .border(
                        width = if (color == selectedColor) 2.dp else 0.dp,
                        color = if (color == selectedColor) Color.Black else Color.Transparent,
                        shape = CircleShape
                    )
                    .clickable { onColorSelected(color) }
            )
        }
    }
}
