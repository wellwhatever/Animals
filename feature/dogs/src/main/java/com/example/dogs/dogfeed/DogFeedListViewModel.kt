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
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import timber.log.Timber

@HiltViewModel
class DogFeedListViewModel @Inject constructor(
    private val getDogFeedUseCase: GetDogFeedUseCase
) : ViewModel() {

    private val dogFeeds = MutableStateFlow<List<DogFeed>>(emptyList())

    val uiState: StateFlow<DogFeedUiState> = dogFeeds.map {
        DogFeedUiState.DogFeedContent(it)
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
                dogFeeds.value = getDogFeedUseCase()
            },
            catch = {
                Timber.e(it)
            }
        )
    }
}

sealed interface DogFeedUiState {
    // Error state is not handled for now,
    // but consider exception handling and mapping it to error state in future
    object Loading : DogFeedUiState
    data class DogFeedContent(
        val dogFeeds: List<DogFeed>
    ) : DogFeedUiState
}