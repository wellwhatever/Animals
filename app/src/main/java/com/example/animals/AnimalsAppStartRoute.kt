package com.example.animals

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.animals.navigation.NavigationGraph
import com.example.animals.navigation.bottom.AnimalsBottomNavigation
import com.example.animals.ui.AnimalsAppState
import com.example.animals.ui.theme.AnimalsTheme

@Composable
fun AnimalsAppStartRoute() {
    AnimalsTheme {
        AnimalsApp()
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AnimalsApp(
    appState: AnimalsAppState = rememberAnimalsAppState()
) {
    Scaffold(bottomBar = {
        AnimalsBottomNavigation(
            navController = appState.navController,
            bottomNavigationItems = appState.bottomNavigationItems
        )
    }) {
        NavigationGraph(
            navHostController = appState.navController,
            modifier = Modifier
                .padding(it)
                .consumeWindowInsets(it)
        )
    }
}

@Composable
fun rememberAnimalsAppState(
    navController: NavHostController = rememberNavController()
): AnimalsAppState = remember(navController) {
    AnimalsAppState(navController)
}