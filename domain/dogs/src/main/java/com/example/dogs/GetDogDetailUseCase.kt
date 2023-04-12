package com.example.dogs

import com.example.common.DispatchersProvider
import com.example.dogs.repositories.DogFeedRepository
import com.example.model.DogFeed
import javax.inject.Inject
import kotlinx.coroutines.withContext

class GetDogDetailUseCase @Inject constructor(
    private val dogFeedRepository: DogFeedRepository,
    private val dispatchersProvider: DispatchersProvider
) {
    suspend operator fun invoke(id: String): DogFeed = withContext(dispatchersProvider.default) {
        dogFeedRepository.getDogFeedById(id)
    }
}