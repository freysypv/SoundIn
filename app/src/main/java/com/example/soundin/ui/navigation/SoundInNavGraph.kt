package com.example.soundin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.soundin.ui.screens.LoginScreen
import com.example.soundin.ui.screens.MainScreen
import com.example.soundin.ui.screens.RegisterScreen


@Composable
fun SoundInNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = SoundInRoutes.LOGIN
    ) {
        composable(SoundInRoutes.LOGIN) {
            LoginScreen(
                onNavigateToRegister = {
                    navController.navigate(route = SoundInRoutes.REGISTER)
                },
                onLoginSuccess = {
                    navController.navigate(route = SoundInRoutes.MAIN) {
                        // Remove Login from the back stack so Back doesn't return to it
                        popUpTo(SoundInRoutes.LOGIN) { inclusive = true }
                    }
                }
            )
        }
        composable(SoundInRoutes.REGISTER) {
            // Register Screen
            RegisterScreen(
                onNavigateToLogin = {
                    navController.navigate(SoundInRoutes.LOGIN)
                }
            )

        }
        composable(SoundInRoutes.MAIN) {
            MainScreen()
        }




    }
}