package com.example.animals.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.animals.navigation.NavigationRoutes.BOTTOM_NAVIGATION_ROUTE
import com.example.animals.navigation.bottom.BottomNavigationItem
import com.example.dogs.dogfeed.DogsFeedListRoute

object NavigationRoutes {
    const val DOG_FEED_DETAILS = "dog_feed_details"
    const val BOTTOM_NAVIGATION_ROUTE = "bottom_navigation_route"
}