package com.htueko.clean.core.di

import com.htueko.clean.core.data.remote.RemoteConfig
import com.htueko.clean.core.data.remote.service.ApiHelper
import com.htueko.clean.core.data.remote.service.ApiService
import com.htueko.clean.core.data.remote.service.ProdRemoteApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    companion object {

        /**
         * to get the base url of the remote service
         *
         * @see [RemoteConfig.BASE_URL]
         */
        @Provides
        fun provideBaseUrl() = RemoteConfig.BASE_URL

        @Singleton
        @Provides
        fun provideRetrofit(): Retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(provideBaseUrl())
            .build()

        @Provides
        @Singleton
        fun provideApiHelper(apiHelper: ProdRemoteApiService): ApiHelper = apiHelper

        @Provides
        @Singleton
        fun provideApiService(retrofit: Retrofit): ApiService =
            retrofit.create(ApiService::class.java)

    }
}