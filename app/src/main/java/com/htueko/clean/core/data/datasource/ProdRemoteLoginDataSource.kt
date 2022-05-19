package com.htueko.clean.core.data.datasource

import com.htueko.clean.core.data.remote.mapper.RemoteMapper
import com.htueko.clean.core.data.remote.service.ApiHelper
import com.htueko.clean.core.domain.model.User
import com.htueko.clean.core.domain.model.status.ResultOf
import javax.inject.Inject

/**
 * to get the response from remote api service and map to desire model then return the result.
 *
 * @param [apiService] - remote operation
 * @param [remoteMapper] - to map the response dto to model
 * @see [ApiHelper]
 * @see [RemoteMapper]
 */
class ProdRemoteLoginDataSource @Inject constructor(
    private val apiService: ApiHelper,
    private val remoteMapper: RemoteMapper,
) : RemoteLoginDataSource {

    override suspend fun getUsers(): ResultOf<List<User>> {
        val response = apiService.getUsers()
        return remoteMapper.toUsers(response)
    }

    override suspend fun registerUser(user: User): ResultOf<User> {
        val response = apiService.registerUser(remoteMapper.fromUser(user))
        return remoteMapper.toUser(response)
    }
}