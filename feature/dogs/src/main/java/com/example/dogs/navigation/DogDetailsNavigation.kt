package com.example.dogs.navigation

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.dogs.dogDetail.DogDetailRoute

internal const val DOG_DETAIL_ARG_ID = "dogDetailId"
private const val DOG_DETAIL_ROUTE = "dog_detail_route"

internal data class DogDetailArgs(val dogsFeedId: String) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(Uri.decode(checkNotNull(savedStateHandle[DOG_DETAIL_ARG_ID])))
}

fun NavController.navigateToDogDetail(dogDetailId: String) {
    this.navigate("$DOG_DETAIL_ROUTE/${Uri.encode(dogDetailId)}")
}

fun NavGraphBuilder.dogDetailScreen() {
    composable(
        route = "$DOG_DETAIL_ROUTE/{$DOG_DETAIL_ARG_ID}",
        arguments = listOf(
            navArgument(DOG_DETAIL_ARG_ID) { type = NavType.StringType }
        )
    ) {
        DogDetailRoute()
    }
}