package com.example.animals

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.animals.navigation.NavigationGraph
import com.example.animals.navigation.bottom.AnimalsBottomNavigation
import com.example.animals.ui.theme.AnimalsTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun AnimalsAppStartRoute() {
    AnimalsTheme {
        val navController = rememberNavController()
        Scaffold(bottomBar = {
            AnimalsBottomNavigation(navController = navController)
        }) {
            NavigationGraph(navHostController = navController)
        }
    }
}