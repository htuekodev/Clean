package com.htueko.clean.core.data.remote.service

import com.htueko.clean.core.data.remote.RemoteConfig
import com.htueko.clean.core.data.remote.dto.UserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * user api service
 */
interface ApiService {

    @GET(RemoteConfig.ENDPOINT_USERS)
    suspend fun getUsers(): Response<List<UserDto>>

    @POST(RemoteConfig.ENDPOINT_USERS)
    suspend fun registerUser(
        @Body user: UserDto
    ): Response<UserDto>
}