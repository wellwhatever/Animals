package com.example.animals.di

import android.content.Context
import com.example.animals.R
import com.example.dogs.di.ApiConfiguration
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ConfigurationModule {
    @Provides
    @Reusable
    fun provideApiConfiguration(@ApplicationContext context: Context): ApiConfiguration =
        with(context) {
            ApiConfiguration(getString(R.string.base_url))
        }
}