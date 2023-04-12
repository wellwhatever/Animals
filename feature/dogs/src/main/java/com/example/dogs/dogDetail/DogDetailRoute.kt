package com.example.dogs.dogDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.compose.CoilLoadingImage
import com.example.compose.FullScreenLoading
import com.example.compose.RefreshScreen
import com.example.compose.theme.AnimalsTheme
import com.example.core.common.R.dimen
import com.example.dogs.DogDetailsPreviewProvider
import com.example.model.DogFeed

@Composable
fun DogDetailRoute(viewModel: DogDetailViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState.collectAsState()
    DogDetailScreen(onRefreshClick = viewModel::onRefreshClicked, uiState = uiState.value)
}

@Composable
fun DogDetailScreen(onRefreshClick: () -> Unit, uiState: DogDetailsUiState) {
    when (uiState) {
        is DogDetailsUiState.Loading -> DogDetailsLoading()
        is DogDetailsUiState.Error -> DogDetailsError(onRefreshClick)
        is DogDetailsUiState.Content -> with(uiState.dogFeed) {
            DogDetailsContent(
                imageUrl = imageUrl,
                dogName = name,
                dogBreed = breed
            )
        }
    }
}

@Composable
fun DogDetailsContent(
    imageUrl: String,
    dogName: String,
    dogBreed: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = dimensionResource(id = dimen.padding_16dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CoilLoadingImage(
            imageUrl = imageUrl, contentDescription = dogName, modifier = Modifier.size(
                dimensionResource(id = dimen.base_image_size_140dp)
            )
        )
        DogDetailsItemTextField(text = dogName, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.width(dimensionResource(id = dimen.spacer_4dp)))
        DogDetailsItemTextField(text = dogBreed, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun DogDetailsItemTextField(
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
fun DogDetailsLoading() {
    FullScreenLoading()
}

@Composable
fun DogDetailsError(onRefreshClick: () -> Unit) {
    RefreshScreen(onRefreshClick = onRefreshClick)
}

@Preview
@Composable
fun DogDetailsContentPreview(
    @PreviewParameter(DogDetailsPreviewProvider::class, limit = 1) dogFeed: DogFeed
) {
    with(dogFeed) {
        AnimalsTheme {
            Surface {
                DogDetailsContent(imageUrl = imageUrl, dogName = name, dogBreed = breed)
            }
        }
    }
}