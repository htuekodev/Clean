package com.htueko.clean.core.domain.usecase

import com.htueko.clean.core.domain.model.User
import com.htueko.clean.core.domain.model.status.ResultOf

interface RegisterUserUseCase {
    suspend operator fun invoke(user: User): ResultOf<User>
}