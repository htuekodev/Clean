package com.htueko.clean.core.data.repository

import com.htueko.clean.core.data.datasource.RemoteLoginDataSource
import com.htueko.clean.core.domain.model.User
import com.htueko.clean.core.domain.model.status.ResultOf
import com.htueko.clean.core.domain.repository.AuthRepository
import javax.inject.Inject

/**
 * repository layer to provide solid data.
 * to provide local data (if exist) and remote data (from server) - caching
 *
 * @param [loginDataSource] single source of data for auth remote operation.
 */
class ProdAuthRepository @Inject constructor(
    private val loginDataSource: RemoteLoginDataSource
) : AuthRepository {
    override suspend fun getUsers(): ResultOf<List<User>> {
        return loginDataSource.getUsers()
    }

    override suspend fun registerUser(user: User): ResultOf<User> {
        return loginDataSource.registerUser(user)
    }

}