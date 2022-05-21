package com.htueko.clean.core.presentation.navigation

/**
 * navigation routes for entire app.
 */
sealed class Screen(val path: Route){
    object LoginRoute: Screen(path = Route.LOGIN)
    object DetailRoute: Screen(path = Route.DETAIL)
}

enum class Route(val route: String) {
    LOGIN("login"),
    DETAIL("detail"),
}