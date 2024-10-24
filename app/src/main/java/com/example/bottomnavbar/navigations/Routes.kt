package com.example.connectmeproject.navigations

sealed class Routes(val route: String) {
    object BottomNav : Routes("BottomNav")
    object Home : Routes("Home")
    object Account : Routes("account")
    object Search : Routes("Search")
    object Favourites : Routes("Fav")
}