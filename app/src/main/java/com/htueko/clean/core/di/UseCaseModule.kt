package com.htueko.clean.core.di

import com.htueko.clean.core.domain.usecase.RegisterUserUseCase
import com.htueko.clean.feature.domain.usecase.ProdRegisterUserUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindRegisterUserUseCase(
        registerUseCase: ProdRegisterUserUseCase
    ): RegisterUserUseCase
}