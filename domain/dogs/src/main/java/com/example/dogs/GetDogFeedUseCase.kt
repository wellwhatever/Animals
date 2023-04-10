package com.example.dogs

import com.example.common.DispatchersProvider
import com.example.dogs.model.DogFeed
import com.example.dogs.repositories.DogFeedRepository
import javax.inject.Inject
import kotlinx.coroutines.withContext

class GetDogFeedUseCase @Inject constructor(
    private val dogFeedRepository: DogFeedRepository,
    private val dispatchersProvider: DispatchersProvider
) {
    suspend operator fun invoke(): List<DogFeed> = withContext(dispatchersProvider.default) {
        dogFeedRepository.getDogFeeds()
    }
}