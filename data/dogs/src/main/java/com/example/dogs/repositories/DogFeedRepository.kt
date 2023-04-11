package com.example.dogs.repositories

import com.example.common.DispatchersProvider
import com.example.dogs.sources.DogFeedApiDataSource
import com.example.model.DogFeed
import javax.inject.Inject
import kotlinx.coroutines.withContext

class DogFeedRepository @Inject internal constructor(
    private val dogFeedApiDataSource: DogFeedApiDataSource,
    private val dispatchersProvider: DispatchersProvider
) {
    suspend fun getDogFeeds(limit: Int): List<DogFeed> = withContext(dispatchersProvider.io) {
        dogFeedApiDataSource.getDogs(limit)
    }
}