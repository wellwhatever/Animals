package com.example.dogs.dogfeed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.DEFAULT_FLOW_SUBSCRIPTION_TIMEOUT
import com.example.common.safeLaunch
import com.example.dogs.GetDogFeedUseCase
import com.example.model.DogFeed
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import timber.log.Timber

@HiltViewModel
class DogFeedListViewModel @Inject constructor(
    private val getDogFeedUseCase: GetDogFeedUseCase
) : ViewModel() {

    private val dogFeeds = MutableStateFlow<List<DogFeed>?>(null)

    // Simplified way to combine uiState with caught exception
    private val errorOccurred = MutableStateFlow(false)

    val uiState: StateFlow<DogFeedUiState> =
        combine(dogFeeds, errorOccurred) { feeds, errorOccurred ->
            when {
                errorOccurred -> DogFeedUiState.Error
                feeds == null -> DogFeedUiState.Loading
                else -> DogFeedUiState.Content(feeds)
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(DEFAULT_FLOW_SUBSCRIPTION_TIMEOUT.inWholeMilliseconds),
            initialValue = DogFeedUiState.Loading
        )

    init {
        fetchDogFeeds()
    }

    private fun fetchDogFeeds() {
        viewModelScope.safeLaunch(
            execute = {
                errorOccurred.value = false
                dogFeeds.value = getDogFeedUseCase(DOGS_LIMIT)
            },
            catch = {
                Timber.e(it)
                errorOccurred.value = true
            }
        )
    }

    fun onRefreshClick() {
        fetchDogFeeds()
    }

    companion object {
        // hardcoded just to limit images
        private const val DOGS_LIMIT = 15
    }
}

sealed interface DogFeedUiState {
    data class Content(
        val dogFeeds: List<DogFeed>
    ) : DogFeedUiState

    object Loading : DogFeedUiState
    object Error : DogFeedUiState
}