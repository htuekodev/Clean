package com.htueko.clean.core.domain.repository

import com.htueko.clean.core.domain.model.User
import com.htueko.clean.core.domain.model.status.ResultOf

interface AuthRepository {
    suspend fun getUsers(): ResultOf<List<User>>
    suspend fun registerUser(user: User): ResultOf<User>
}