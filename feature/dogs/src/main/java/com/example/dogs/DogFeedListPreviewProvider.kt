package com.example.dogs

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.model.DogFeed

val previewDogs = listOf(
    DogFeed("id1", "", "Cool Dog", "Cool breed"),
    DogFeed("id2", "", "Nice Dog", "Nice breed"),
    DogFeed("id3", "", "Amazing Dog", "Amazing breed"),
    DogFeed("id4", "", "Bad Dog", "Bad breed")
)

class DogFeedListPreviewProvider(
    override val values: Sequence<List<DogFeed>> = sequenceOf(
        previewDogs
    )
) : PreviewParameterProvider<List<DogFeed>>

class DogDetailsPreviewProvider(override val values: Sequence<DogFeed> = previewDogs.asSequence()) :
    PreviewParameterProvider<DogFeed>