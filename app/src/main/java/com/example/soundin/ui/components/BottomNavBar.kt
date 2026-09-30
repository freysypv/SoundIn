package com.example.soundin.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.soundin.ui.navigation.SoundInRoutes

@Composable
fun BottomNavigationBar(
    currentRoute: String?,
    onNavigate: (String) -> Unit
) {
    NavigationBar {
        val items = listOf(
            Triple(SoundInRoutes.LIBRARY, "Library", Icons.Default.LibraryMusic),
            Triple(SoundInRoutes.SEARCH, "Search", Icons.Default.Search),
            Triple(SoundInRoutes.PROFILE, "Profile", Icons.Default.Person)
        )

        items.forEach { (route, label, icon) ->
            NavigationBarItem(
                selected = currentRoute == route,
                onClick = { onNavigate(route) },
                icon = { Icon(imageVector = icon, contentDescription = label) },
                label = { Text(label) }
            )
        }
    }
}