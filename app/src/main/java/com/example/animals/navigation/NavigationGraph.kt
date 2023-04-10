package com.example.animals.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.animals.navigation.bottom.BottomNavigationItem
import com.example.dogs.dogfeed.DogsFeedListRoute

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationRoutes.BOTTOM_NAVIGATION_ROUTE
    ) {
        bottomNavigationMenu(navHostController)
    }
}

fun NavGraphBuilder.bottomNavigationMenu(navHostController: NavHostController) {
    navigation(
        startDestination = BottomNavigationItem.Dogs.screenRoute,
        route = NavigationRoutes.BOTTOM_NAVIGATION_ROUTE
    ) {
        composable(BottomNavigationItem.Dogs.screenRoute) {
            DogsFeedListRoute()
        }
        composable(BottomNavigationItem.Cats.screenRoute) {
            // TODO: add cats screen route after implementation
        }
        composable(BottomNavigationItem.Other.screenRoute) {
            // TODO: add other screen route after implementation
        }
    }
}