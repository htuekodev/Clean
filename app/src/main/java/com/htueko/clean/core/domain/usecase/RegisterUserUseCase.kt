package com.htueko.clean.core.domain.usecase

import com.htueko.clean.core.domain.model.User
import com.htueko.clean.core.domain.model.status.ResultOf

/**
 * This use case consumes any information required to log in the user, and attempts to do so.
 */
interface RegisterUserUseCase {
    /**
     * This function accept [user] and login
     *
     * @return a [ResultOf] that have success for failure.
     */
    suspend operator fun invoke(
        user: User
    ): ResultOf<User>
}