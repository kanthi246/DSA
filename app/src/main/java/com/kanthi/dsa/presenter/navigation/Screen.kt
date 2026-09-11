package com.kanthi.dsa.presenter.navigation

sealed class Screen(val route : String) {

    object UserScreen : Screen("user_screen")

    object UserDetail : Screen("user_detail/{userId}") {
        fun createRoute(userId: Int): String = "user_detail/$userId"
    }

}

