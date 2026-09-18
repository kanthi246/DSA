package com.kanthi.dsa.presenter.navigation

/** Defines routes used by the user navigation graph. */
sealed class Screen(val route : String) {

    /** Route for the list of users. */
    object UserScreen : Screen("user_screen")

    /** Route for details of a user identified by ID. */
    object UserDetail : Screen("user_detail/{userId}") {
        /** Builds a concrete detail route for [userId]. */
        fun createRoute(userId: Int): String = "user_detail/$userId"
    }

}

