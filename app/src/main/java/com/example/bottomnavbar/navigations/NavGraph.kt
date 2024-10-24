package com.example.connectmeproject.navigations


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.connectmeproject.screens.Account
import com.example.connectmeproject.screens.BottomNav
import com.example.connectmeproject.screens.Favourites
import com.example.connectmeproject.screens.Home
import com.example.connectmeproject.screens.MyBottomBar
import com.example.connectmeproject.screens.Search


@Composable
fun NavGraph(navController: NavHostController) {
    Scaffold(
        bottomBar = { MyBottomBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.BottomNav.route) {
                BottomNav(navController)
            }

            composable(Routes.Home.route) {
                Home(navController)
            }

            composable(Routes.Account.route) {
                Account(navController)
            }

            composable(Routes.Search.route) {
                Search(navController)
            }

            composable(Routes.Favourites.route) {
                Favourites(navController)
            }

            composable(Routes.Search.route) {
                Search(navController)
            }

        }
    }
}





