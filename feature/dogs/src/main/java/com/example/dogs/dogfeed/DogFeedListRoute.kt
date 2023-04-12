package com.example.dogs.dogfeed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.compose.CoilLoadingImage
import com.example.compose.FullScreenLoading
import com.example.compose.RefreshScreen
import com.example.core.common.R.dimen
import com.example.model.DogFeed

@Composable
fun DogsFeedListRoute(
    onDogFeedClick: (String) -> Unit,
    viewModel: DogFeedListViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    DogsFeedScreen(
        onDogFeedClick = onDogFeedClick,
        onRefreshClick = viewModel::onRefreshClick,
        uiState = uiState
    )
}

@Composable
fun DogsFeedScreen(
    onDogFeedClick: (String) -> Unit,
    onRefreshClick: () -> Unit,
    uiState: DogFeedUiState
) {
    when (uiState) {
        is DogFeedUiState.Loading -> DogsFeedLoading()
        is DogFeedUiState.Error -> DogsFeedError(onRefreshClick)
        is DogFeedUiState.Content -> DogsFeedContent(
            onDogFeedClick = onDogFeedClick,
            dogFeeds = uiState.dogFeeds
        )
    }
}

@Composable
fun DogsFeedContent(
    onDogFeedClick: (String) -> Unit,
    dogFeeds: List<DogFeed>
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = dimensionResource(id = dimen.padding_8dp))
    ) {
        dogFeeds.forEachIndexed { index, feed ->
            item(feed.id) {
                DogFeedItem(
                    onDogFeedClick = onDogFeedClick,
                    imageUrl = feed.imageUrl,
                    feedId = feed.id,
                    dogName = feed.name,
                    dogBreed = feed.breed
                )
                if (index != dogFeeds.lastIndex) {
                    Spacer(modifier = Modifier.width(dimensionResource(id = dimen.spacer_8dp)))
                }
            }
        }
    }
}

@Composable
fun DogFeedItem(
    onDogFeedClick: (String) -> Unit,
    imageUrl: String,
    dogName: String,
    dogBreed: String,
    feedId: String
) {
    Row(
        modifier = Modifier
            .padding(dimensionResource(id = dimen.padding_4dp))
            .fillMaxWidth()
            .clickable {
                onDogFeedClick(feedId)
            }
    ) {
        CoilLoadingImage(
            modifier = Modifier
                .size(dimensionResource(id = dimen.base_image_size_100dp))
                .clip(MaterialTheme.shapes.medium),
            imageUrl = imageUrl
        )
        Spacer(modifier = Modifier.width(dimensionResource(id = dimen.spacer_8dp)))

        Column {
            DogFeedItemTextField(text = dogName, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.width(dimensionResource(id = dimen.spacer_4dp)))
            DogFeedItemTextField(text = dogBreed, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.width(dimensionResource(id = dimen.spacer_4dp)))
        }
    }
}

@Composable
fun DogFeedItemTextField(
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    text: String,
    style: TextStyle
) {
    Text(
        modifier = modifier,
        textAlign = textAlign,
        text = text,
        style = style
    )
}

@Composable
fun DogsFeedLoading() {
    FullScreenLoading()
}

@Composable
fun DogsFeedError(onRefreshClick: () -> Unit) {
    RefreshScreen(onRefreshClick = onRefreshClick)
}