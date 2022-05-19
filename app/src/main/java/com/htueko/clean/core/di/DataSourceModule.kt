package com.htueko.clean.core.di

import com.htueko.clean.core.data.datasource.ProdRemoteLoginDataSource
import com.htueko.clean.core.data.datasource.RemoteLoginDataSource
import com.htueko.clean.core.data.remote.mapper.RemoteMapper
import com.htueko.clean.core.data.remote.service.ApiHelper
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    /**
     * to bind the remote datasource interface to implementation class.
     */
    @Binds
    abstract fun bindRemoteDataSource(datasource: ProdRemoteLoginDataSource): RemoteLoginDataSource

    companion object {

        @Provides
        @Singleton
        fun provideRemoteMapper(): RemoteMapper = RemoteMapper()

        /**
         * to provide datasource implementation class for remote operation with api interface and wrapper class.
         *
         * @param [apiService] - api service interface
         * @param [remoteMapper] - wrapper mapper class
         */
        @Provides
        @Singleton
        fun provideRemoteLoginDataSource(
            apiService: ApiHelper,
            remoteMapper: RemoteMapper,
        ): ProdRemoteLoginDataSource {
            return ProdRemoteLoginDataSource(apiService, remoteMapper)
        }
    }
}