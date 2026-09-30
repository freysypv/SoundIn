package com.example.soundin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.soundin.ui.components.BottomNavigationBar
import com.example.soundin.ui.navigation.SoundInRoutes
import com.example.soundin.ui.theme.SoundinTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()// manage the connection between the screens
    val currentBackStackEntry by navController.currentBackStackEntryAsState()// get the current route
    val currentRoute = currentBackStackEntry?.destination?.route // save the current route

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentRoute = currentRoute,
                onNavigate = {route ->
                    navController.navigate(route){
                        popUpTo (navController.graph.startDestinationId) {  // pop up to the start destination of the graph to avoid the back stack
                            saveState = true // save the state of the previous screen, user interface , keep it were the user was in the scroll
                        }
                        launchSingleTop = true // avoid multiple copies of the same destination
                        restoreState = true // restore the state of the previous screen, user interface , keep it were the user was in the scroll
                    }

                }
            ) // end BottomNavigationBar
        }
    ) {
        paddingValues ->
        NavHost(
            navController = navController,
            startDestination = SoundInRoutes.LIBRARY,
            modifier = Modifier.padding(paddingValues)
        ){
            composable ( route = SoundInRoutes.LIBRARY){ LibraryScreen()}
            composable ( route = SoundInRoutes.SEARCH){ SearchScreen()}
            composable ( route = SoundInRoutes.PROFILE){ ProfileScreen()}
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun MainScreenPreview() {
//    SoundinTheme {
//        MainScreen()
//    }
//}

