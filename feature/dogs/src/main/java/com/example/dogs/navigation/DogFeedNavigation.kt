package com.example.dogs.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.dogs.dogfeed.DogsFeedListRoute

const val DOG_FEED_NAVIGATION_GRAPH = "dog_feed_graph"
const val DOG_FEED_ROUTE = "dog_feed_route"

fun NavController.navigateToDogFeedGraph(navOptions: NavOptions? = null) {
    this.navigate(DOG_FEED_NAVIGATION_GRAPH, navOptions)
}

fun NavGraphBuilder.dogFeedGraph(
    onDogFeedClicked: (String) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = DOG_FEED_NAVIGATION_GRAPH,
        startDestination = DOG_FEED_ROUTE
    ) {
        composable(route = DOG_FEED_ROUTE) {
            DogsFeedListRoute(onDogFeedClick = onDogFeedClicked)
        }
        nestedGraphs()
    }
}