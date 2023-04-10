package com.example.animals.navigation.bottom

import androidx.navigation.NavController

interface BottomNavigationAction {
    fun onNavigate(navController: NavController, item: BottomNavigationItem)
}