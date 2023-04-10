package com.example.dogs

import com.example.common.DispatchersProvider
import com.example.dogs.model.DogFeed
import com.example.dogs.repositories.DogFeedsRepository
import javax.inject.Inject
import kotlinx.coroutines.withContext

class GetDogFeedsUseCase @Inject constructor(
    private val dogFeedsRepository: DogFeedsRepository,
    private val dispatchersProvider: DispatchersProvider
) {
    suspend operator fun invoke(): List<DogFeed> = withContext(dispatchersProvider.default) {
        dogFeedsRepository.getDogFeeds()
    }
}