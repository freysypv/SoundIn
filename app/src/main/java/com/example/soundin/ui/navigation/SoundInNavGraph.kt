package com.example.soundin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.soundin.ui.screens.LoginScreen
import com.example.soundin.ui.screens.MainScreen
import com.example.soundin.ui.screens.PlaylistDetailScreen
import com.example.soundin.ui.screens.RegisterScreen
import com.example.soundin.ui.viewModel.UserSessionViewModel


@Composable
fun SoundInNavGraph(
    navController: NavHostController,
    sessionViewModel: UserSessionViewModel
) {
    NavHost(
        navController = navController,
        startDestination = SoundInRoutes.LOGIN
    ) {
        composable(SoundInRoutes.LOGIN) {
            LoginScreen(
                sessionViewModel = sessionViewModel,
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
            MainScreen(
                sessionViewModel = sessionViewModel,
                onLogout = {
                    sessionViewModel.logout()
                    navController.navigate(SoundInRoutes.LOGIN) {
                        popUpTo(navController.graph.id) { inclusive = true }

                    }// end navigate
                },// end onLogout
                onNavigateToPlaylistDetail = {playlist ->
                    navController.navigate( route = "playlistDetail/${playlist.id}")
                }
            )
        }
        composable(
            route = SoundInRoutes.PLAYLIST_DETAIL,
            arguments = listOf(navArgument("playlistID") { type = NavType.IntType })
        ){
            backStackEntry ->
            val playlistID = backStackEntry.arguments?.getInt("playlistId") ?: 0
            PlaylistDetailScreen(
                // here we control the navigation to the previous screen
                onNavigateBack = { navController.popBackStack()}
            )
        }



    }
}