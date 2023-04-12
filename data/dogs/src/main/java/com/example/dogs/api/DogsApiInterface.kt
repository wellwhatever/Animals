package com.example.dogs.api

import com.example.dogs.response.DogFeedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface DogsApiInterface {
    @GET("/v1/images/search")
    suspend fun getDogs(
        @Query("limit") limit: Int,
        @Query("has_breeds") hasBreeds: Boolean
    ): Response<List<DogFeedResponse>>

    @GET("v1/images/{id}")
    suspend fun getDog(
        @Path("id") id: String
    ): Response<DogFeedResponse>
}