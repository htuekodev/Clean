package com.htueko.clean.core.data.datasource

import com.htueko.clean.core.domain.model.User
import com.htueko.clean.core.domain.model.status.ResultOf

/**
 * single source of data for remote login operations.
 */
interface RemoteLoginDataSource {

    suspend fun getUsers(): ResultOf<List<User>>

    suspend fun registerUser(user: User): ResultOf<User>
}