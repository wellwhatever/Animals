package com.example.dogs.di

import com.example.data.dogs.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class DogsAuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val builder =
            originalRequest.newBuilder().header("x-api-key", BuildConfig.DOGS_API_KEY_SECRET)
        return chain.proceed(builder.build())
    }
}