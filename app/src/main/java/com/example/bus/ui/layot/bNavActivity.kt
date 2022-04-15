package com.example.bus.ui.layot

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bus.FindTicketsScreen
import com.example.bus.bNav.BottomNavItem


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            FindTicketsScreen()
        }
        composable(BottomNavItem.Schelude.screen_route) {
            NetworkScreen()
        }
        composable(BottomNavItem.Profile.screen_route) {
            AddPostScreen()
        }

    }
}