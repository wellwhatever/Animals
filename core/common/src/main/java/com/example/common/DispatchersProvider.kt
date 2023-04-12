package com.example.common

import kotlinx.coroutines.CoroutineDispatcher

class DispatchersProvider constructor(
    val io: CoroutineDispatcher,
    val main: CoroutineDispatcher,
    val default: CoroutineDispatcher,
)