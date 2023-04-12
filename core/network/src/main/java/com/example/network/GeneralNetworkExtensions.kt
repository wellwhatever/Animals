package com.example.network

import retrofit2.HttpException
import retrofit2.Response

fun <T> Response<T>.bodyOrException(): T {
    val body = body()
    return when {
        isSuccessful && body != null -> body
        isSuccessful && body == null -> error("Response contains no body")
        else -> throw HttpException(this)
    }
}