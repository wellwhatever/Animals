package com.example.animals.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.animals.navigation.bottom.BottomNavigationItem
import com.example.dogs.dogfeed.DogsFeedListRoute

@Composable
fun NavigationGraph(
    navHostController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationRoutes.BOTTOM_NAVIGATION_ROUTE,
        modifier = modifier
    ) {
        // Define your graphs/nested graphs here
        bottomNavigationMenu()
    }
}

fun NavGraphBuilder.bottomNavigationMenu() {
    navigation(
        startDestination = BottomNavigationItem.Dogs.route,
        route = NavigationRoutes.BOTTOM_NAVIGATION_ROUTE
    ) {
        composable(BottomNavigationItem.Dogs.route) {
            DogsFeedListRoute()
        }
        composable(BottomNavigationItem.Cats.route) {
            // TODO: add cats screen route after implementation
        }
        composable(BottomNavigationItem.Other.route) {
            // TODO: add other screen route after implementation
        }
    }
}