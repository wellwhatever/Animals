package com.example.animals.navigation.bottom

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.unit.dp
import com.example.animals.R

sealed class BottomNavigationItem(
    @StringRes val titleRes: Int,
    @DrawableRes var iconRes: Int,
    val screenRoute: String
) {
    object Dogs :
        BottomNavigationItem(
            R.string.bottom_navigation_dogs_route_title,
            R.drawable.ic_thumb_up,
            "dogs"
        )

    object Cats : BottomNavigationItem(
        R.string.bottom_navigation_cats_route_title,
        R.drawable.ic_thumb_down,
        "cats"
    )

    object Other : BottomNavigationItem(
        R.string.bottom_navigation_other_route_title,
        R.drawable.ic_wrong_location,
        "other"
    )

    companion object {
        val iconDefaultSize = 24.dp
    }
}