package com.example.dogs.dogDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.DEFAULT_FLOW_SUBSCRIPTION_TIMEOUT
import com.example.common.safeLaunch
import com.example.dogs.GetDogDetailUseCase
import com.example.dogs.navigation.DogDetailArgs
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
class DogDetailViewModel @Inject constructor(
    private val getDogDetailUseCase: GetDogDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val dogDetailArgs: DogDetailArgs = DogDetailArgs(savedStateHandle)

    private val dogDetail = MutableStateFlow<DogFeed?>(null)

    // Simplified way to combine uiState with caught exception
    private val errorOccurred = MutableStateFlow(false)

    val uiState: StateFlow<DogDetailsUiState> =
        combine(dogDetail, errorOccurred) { dog, errorOccurred ->
            when {
                errorOccurred -> DogDetailsUiState.Error
                dog == null -> DogDetailsUiState.Loading
                else -> DogDetailsUiState.Content(dog)
            }
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(DEFAULT_FLOW_SUBSCRIPTION_TIMEOUT.inWholeMilliseconds),
            DogDetailsUiState.Loading
        )

    init {
        fetchDogDetail()
    }

    private fun fetchDogDetail() {
        viewModelScope.safeLaunch(
            execute = {
                errorOccurred.value = false
                dogDetail.value = getDogDetailUseCase(dogDetailArgs.dogsFeedId)
            },
            catch = {
                Timber.e(it)
                errorOccurred.value = true
            }
        )
    }

    fun onRefreshClicked() {
        fetchDogDetail()
    }
}

sealed interface DogDetailsUiState {
    data class Content(
        val dogFeed: DogFeed
    ) : DogDetailsUiState

    object Loading : DogDetailsUiState
    object Error : DogDetailsUiState
}