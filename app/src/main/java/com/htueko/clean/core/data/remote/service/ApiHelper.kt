package com.htueko.clean.core.data.remote.service

import com.htueko.clean.core.data.remote.dto.UserDto
import com.htueko.clean.core.domain.model.status.ResultOf

/**
 * to separation of concern for network operation
 *
 * @see [ProdRemoteApiService]
 */
interface ApiHelper {

    /**
     * to get the user objects.
     *
     * @return list of [UserDto] or other
     * @see [ResultOf]
     */
    suspend fun getUsers(): ResultOf<List<UserDto>>

    /**
     * to register the user object.
     *
     * @param [user] an instance of [UserDto]
     * @return [UserDto] or other
     * @see [ResultOf]
     */
    suspend fun registerUser(user: UserDto): ResultOf<UserDto>
}