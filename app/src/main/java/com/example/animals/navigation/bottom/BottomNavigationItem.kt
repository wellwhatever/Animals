package com.example.animals.navigation.bottom

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.unit.dp
import com.example.animals.R
import com.example.common.AppNavigationDestination
import com.example.dogs.navigation.DOG_FEED_ROUTE

sealed class BottomNavigationItem(
    @StringRes val titleRes: Int,
    @DrawableRes var iconRes: Int,
    override val route: String,
    override val destination: String
) : AppNavigationDestination {
    object Dogs :
        BottomNavigationItem(
            titleRes = R.string.bottom_navigation_dogs_route_title,
            iconRes = R.drawable.ic_thumb_up,
            route = DOG_FEED_ROUTE,
            destination = "dogs_destination"
        )

    object Cats : BottomNavigationItem(
        titleRes = R.string.bottom_navigation_cats_route_title,
        iconRes = R.drawable.ic_thumb_down,
        route = "cats_route",
        destination = "cats_destination"
    )

    object Other : BottomNavigationItem(
        titleRes = R.string.bottom_navigation_other_route_title,
        iconRes = R.drawable.ic_wrong_location,
        route = "other_route",
        destination = "other_destination"
    )

    companion object {
        val iconDefaultSize = 24.dp
    }
}