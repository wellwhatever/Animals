package com.example.dogs.di

import com.example.dogs.api.DogsApiInterface
import com.example.dogs.converters.DogFeedResponseConverter
import com.example.network.di.NetworkModule
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object DogsDataModule {
    @Provides
    @Singleton
    @Dogs
    internal fun provideDogsOkHttp(
        @NetworkModule.Default okHttpClient: OkHttpClient
    ): OkHttpClient = okHttpClient.newBuilder().addInterceptor(DogsAuthInterceptor()).build()

    @Provides
    @Singleton
    @Dogs
    internal fun provideDogsRetrofit(
        @Dogs okHttpClient: OkHttpClient,
        @NetworkModule.Default moshi: Moshi,
        @NetworkModule.Default apiConfiguration: ApiConfiguration
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(apiConfiguration.baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient).build()

    @Provides
    @Singleton
    internal fun provideDogsInterface(
        @Dogs retrofit: Retrofit
    ): DogsApiInterface = retrofit.create(DogsApiInterface::class.java)

    @Provides
    @Reusable
    internal fun provideDogFeedResponseConverter(): DogFeedResponseConverter =
        DogFeedResponseConverter()

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Dogs
}