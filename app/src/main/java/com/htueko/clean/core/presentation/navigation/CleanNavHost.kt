package com.htueko.clean.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.htueko.clean.feature.detail.ui.view.DetailScreen
import com.htueko.clean.feature.login.ui.view.LoginScreen

/**
 * centralise control of navigation and passing argument for the app.
 */
@Composable
fun CleanNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.DetailRoute.path.route
    ) {
        // login screen
        composable(
            route = Screen.LoginRoute.path.route,
        ) {
            LoginScreen(
                onLoginClicked = { userName ->
                    navHostController.navigate(
                        Screen.DetailRoute.path.route + "/$userName"
                    )
                }
            )
        }
        // detail screen
        composable(
            route = Screen.DetailRoute.path.route + "/{name}",
        ) {
            DetailScreen()
        }
    }
}