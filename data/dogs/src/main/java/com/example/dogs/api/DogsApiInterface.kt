package com.example.dogs.api

import com.example.dogs.response.DogFeedResponse
import retrofit2.Response
import retrofit2.http.GET

internal interface DogsApiInterface {
    @GET("/images/search")
    suspend fun getDogs(): Response<List<DogFeedResponse>>
}