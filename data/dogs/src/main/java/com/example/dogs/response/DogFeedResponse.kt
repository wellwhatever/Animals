package com.example.dogs.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DogFeedResponse(
    @Json(name = "id")
    val id: String,
    @Json(name = "url")
    val imageUrl: String,
    @Json(name = "breeds")
    val breeds: List<DogBreed>
)