package com.htueko.clean.feature.login.domain.usecase

import com.htueko.clean.core.domain.model.User
import com.htueko.clean.core.domain.model.status.ResultOf
import com.htueko.clean.core.domain.repository.AuthRepository
import com.htueko.clean.core.domain.usecase.RegisterUserUseCase
import javax.inject.Inject

class ProdRegisterUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
) : RegisterUserUseCase {

    override suspend fun invoke(user: User): ResultOf<User> {
        return authRepository.registerUser(user)
    }

}