package com.example.dogs.converters

import com.example.dogs.model.DogFeed
import com.example.dogs.response.DogFeedResponse

internal class DogFeedResponseConverter {
    fun toDomainObject(dogFeedResponse: DogFeedResponse): DogFeed = with(dogFeedResponse) {
        DogFeed(
            id = id,
            imageUrl = imageUrl
        )
    }
}