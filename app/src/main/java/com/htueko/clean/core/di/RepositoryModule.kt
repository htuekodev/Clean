package com.htueko.clean.core.di

import com.htueko.clean.core.data.datasource.RemoteLoginDataSource
import com.htueko.clean.core.data.repository.ProdAuthRepository
import com.htueko.clean.core.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    /**
     * to bind the repository interface to implementation class.
     */
    @Binds
    abstract fun bindRepository(repository: ProdAuthRepository): AuthRepository

    companion object {

        /**
         * to provide repository implementation class with local datasource (if exist) and remote datasource (from server).
         *
         * @param [remoteDataSource] - single source of data from remote operations.
         */
        @Provides
        @Singleton
        fun provideAuthRepository(
            remoteDataSource: RemoteLoginDataSource,
        ): ProdAuthRepository {
            return ProdAuthRepository(
                loginDataSource = remoteDataSource
            )
        }
    }
}