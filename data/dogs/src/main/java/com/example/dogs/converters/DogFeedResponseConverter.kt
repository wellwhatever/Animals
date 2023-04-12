package com.example.dogs.converters

import com.example.dogs.response.DogFeedResponse
import com.example.model.DogFeed

internal class DogFeedResponseConverter {
    fun toDomainObject(dogFeedResponse: DogFeedResponse): DogFeed = with(dogFeedResponse) {
        DogFeed(
            id = id,
            imageUrl = imageUrl,
            // For simplified purposes we'll use only first occurrence of dog's breed from response
            name = breeds.firstOrNull()?.name.orEmpty(),
            breed = breeds.firstOrNull()?.breedGroup.orEmpty()
        )
    }
}