package com.example.animals.ui

import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController
import com.example.animals.navigation.bottom.BottomNavigationItem
import kotlinx.collections.immutable.persistentListOf

@Stable
class AnimalsAppState(
    val navController: NavHostController
) {
    val bottomNavigationItems = persistentListOf(
        BottomNavigationItem.Dogs,
        BottomNavigationItem.Cats,
        BottomNavigationItem.Other
    )
}
