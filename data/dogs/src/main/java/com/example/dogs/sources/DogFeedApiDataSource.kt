package com.example.dogs.sources

import com.example.dogs.api.DogsApiInterface
import com.example.dogs.converters.DogFeedResponseConverter
import com.example.model.DogFeed
import com.example.network.bodyOrException
import javax.inject.Inject

internal class DogFeedApiDataSource @Inject constructor(
    private val dogsApiInterface: DogsApiInterface,
    private val dogsFeedResponseConverter: DogFeedResponseConverter
) {
    suspend fun getDogs(limit: Int): List<DogFeed> =
        dogsApiInterface.getDogs(limit).bodyOrException()
            .map { dogsFeedResponseConverter.toDomainObject(it) }
}