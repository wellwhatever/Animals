package com.example.animals.navigation.bottom

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.collections.immutable.ImmutableList

@Composable
fun AnimalsBottomNavigation(
    navController: NavController,
    bottomNavigationItems: ImmutableList<BottomNavigationItem>
) {
    BottomNavigation(navController = navController, navigationItems = bottomNavigationItems)
}

@Composable
fun BottomNavigation(
    navController: NavController,
    navigationItems: ImmutableList<BottomNavigationItem>
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        navigationItems.forEach { navigationItem ->
            NavigationBarItem(
                icon = {
                    Icon(
                        modifier = Modifier.size(BottomNavigationItem.iconDefaultSize),
                        painter = painterResource(id = navigationItem.iconRes),
                        contentDescription = stringResource(id = navigationItem.titleRes)
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = navigationItem.titleRes),
                        style = MaterialTheme.typography.labelMedium
                    )
                },
                selected = currentRoute == navigationItem.route,
                onClick = {
                    BottomNavigationClickHandler.navigate(navController, navigationItem)
                }
            )
        }
    }
}

object BottomNavigationClickHandler : BottomNavigationAction {
    override fun navigate(navController: NavController, item: BottomNavigationItem) {
        navController.navigate(item.route) {
            navController.graph.startDestinationRoute?.let { screenRoute ->
                popUpTo(screenRoute) {
                    saveState = true
                }
            }
            // Only one copy of destinations
            launchSingleTop = true
            // Restore previously saved state
            restoreState = true
        }
    }

}