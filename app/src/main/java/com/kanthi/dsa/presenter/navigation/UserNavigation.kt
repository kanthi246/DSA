package com.kanthi.dsa.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kanthi.dsa.presenter.userscreen.UserDetailScreen
import com.kanthi.dsa.presenter.userscreen.UserScreen
import com.kanthi.dsa.presenter.userscreen.UserViewModel


@Composable
fun UserNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.UserScreen.route){
        composable(Screen.UserScreen.route) {
            UserScreen(
                onUserClick = { user ->
                    navController.navigate(Screen.UserDetail.createRoute(user.id))
                }
            )
        }
        composable(
            route = Screen.UserDetail.route,
            arguments = listOf(navArgument("userId") { type = NavType.IntType })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getInt("userId") ?: return@composable
            val usersEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Screen.UserScreen.route)
            }
            val userViewModel: UserViewModel = hiltViewModel(usersEntry)

            UserDetailScreen(
                userId = userId,
                userViewModel = userViewModel,
                onNavigateBack = navController::navigateUp
            )
        }
    }

}
