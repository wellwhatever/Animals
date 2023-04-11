package com.example.animals.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.animals.navigation.bottom.BottomNavigationItem
import com.example.dogs.navigation.DOG_FEED_NAVIGATION_GRAPH
import com.example.dogs.navigation.dogDetailScreen
import com.example.dogs.navigation.dogFeedGraph
import com.example.dogs.navigation.navigateToDogDetail
import com.example.dogs.navigation.navigateToDogFeedGraph

@Composable
fun NavigationGraph(
    navHostController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = DOG_FEED_NAVIGATION_GRAPH,
        modifier = modifier
    ) {
        dogFeedGraph(
            onDogFeedClicked = { dogFeedId ->
                navHostController.navigateToDogDetail(dogFeedId)
            },
            nestedGraphs = {
                dogDetailScreen(
                    onBackClick = navHostController::navigateToDogFeedGraph
                )
            }
        )

        // TODO: For others top up destinations provide same graph build as for dogFeedGraph
        //  left like this for simplification
        composable(BottomNavigationItem.Cats.route) {
            // TODO: add cats screen route after implementation
        }
        composable(BottomNavigationItem.Other.route) {
            // TODO: add other screen route after implementation
        }
    }
}