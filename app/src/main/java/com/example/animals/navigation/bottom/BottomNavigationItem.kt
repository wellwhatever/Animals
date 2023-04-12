package com.example.animals.navigation.bottom

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.unit.dp
import com.example.animals.R
import com.example.dogs.navigation.DOG_FEED_ROUTE

sealed class BottomNavigationItem(
    @StringRes val titleRes: Int,
    @DrawableRes var iconRes: Int,
    val route: String
) {
    object Dogs :
        BottomNavigationItem(
            titleRes = R.string.bottom_navigation_dogs_route_title,
            iconRes = R.drawable.ic_thumb_up,
            route = DOG_FEED_ROUTE
        )

    object Cats : BottomNavigationItem(
        titleRes = R.string.bottom_navigation_cats_route_title,
        iconRes = R.drawable.ic_thumb_down,
        route = "cats_route"
    )

    object Other : BottomNavigationItem(
        titleRes = R.string.bottom_navigation_other_route_title,
        iconRes = R.drawable.ic_wrong_location,
        route = "other_route"
    )

    companion object {
        val iconDefaultSize = 24.dp
    }
}