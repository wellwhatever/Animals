package com.example.animals.navigation.bottom

import androidx.navigation.NavController

interface BottomNavigationAction {
    fun navigate(navController: NavController, item: BottomNavigationItem)
}