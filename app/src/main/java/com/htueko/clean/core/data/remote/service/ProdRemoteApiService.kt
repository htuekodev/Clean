package com.htueko.clean.core.data.remote.service

import com.htueko.clean.core.data.remote.dto.UserDto
import com.htueko.clean.core.domain.model.status.ResultOf
import javax.inject.Inject

/**
 * implementation of [ApiHelper] with [ApiService]
 *
 * @param [apiService] user api service
 * @see [ApiHelper]
 */
class ProdRemoteApiService @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {

    override suspend fun getUsers(): ResultOf<List<UserDto>> {
        return try {
            val response = apiService.getUsers()
            if (!response.isSuccessful) {
                ResultOf.ApiError(response.message())
            } else {
                if (response.body() == null) {
                    return ResultOf.ApiError(response.message())
                }
                ResultOf.Success(response.body()!!)
            }
        } catch (e: Exception) {
            ResultOf.NetworkError(e)
        }
    }

    override suspend fun registerUser(user: UserDto): ResultOf<UserDto> {
        return try {
            val response = apiService.registerUser(user)
            if (!response.isSuccessful) {
                ResultOf.ApiError(response.message())
            } else {
                if (response.body() == null) {
                    return ResultOf.ApiError(response.message())
                }
                ResultOf.Success(response.body()!!)
            }
        } catch (e: Exception) {
            ResultOf.NetworkError(e)
        }
    }
}