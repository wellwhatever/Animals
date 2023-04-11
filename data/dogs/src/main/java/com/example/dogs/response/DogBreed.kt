package com.example.dogs.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DogBreed(
    @Json(name = "name")
    val name: String,
    @Json(name = "breed_group")
    val breedGroup: String
)
