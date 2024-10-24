package com.example.connectmeproject.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.connectmeproject.model.BotNavItem
import com.example.connectmeproject.navigations.Routes

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNav(navController: NavHostController) {
    val navController1 = rememberNavController()
    Scaffold(
        bottomBar = { MyBottomBar(navController1) }
    ) { innerPadding ->
        NavHost(
            navController = navController1,
            startDestination = Routes.Home.route, // Set start destination to Home
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Routes.Home.route) {
                Home(navController) // Navigate to HomeScreen
            }
            composable(Routes.Search.route) {
                Search(navController) // Navigate to ProfileScreen
            }

            composable(Routes.Favourites.route) {
                Favourites(navController)
            }

            composable(Routes.Account.route) {
                Account(navController) // Navigate to SettingsScreen
            }
        }
    }
}

@Composable
fun MyBottomBar(navController1: NavHostController) {
    val backStackEntry = navController1.currentBackStackEntryAsState()
    val list = listOf(

        BotNavItem(
            "Home",
            Routes.Home.route,
            Icons.Rounded.Home
        ),
        BotNavItem(
            "Search",
            Routes.Search.route,
            Icons.Rounded.Search
        ),
        BotNavItem(
            "Favourites",
            Routes.Favourites.route,
            Icons.Rounded.FavoriteBorder
        ),
        BotNavItem(
            "Account",
            Routes.Account.route,
            Icons.Rounded.AccountCircle
        )
    )

    BottomAppBar( modifier = Modifier
        .clip(RoundedCornerShape(14.dp))) {
        list.forEach {

            val selected = it.route == backStackEntry.value?.destination?.route

            NavigationBarItem(selected = selected, onClick = {
                navController1.navigate(it.route) {
                    popUpTo(navController1.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                }
            }, icon = {
                Icon(imageVector = it.icon, contentDescription = null)
            },
                label = {
                    Text(text = it.title)
                }
            )
        }
    }
}
