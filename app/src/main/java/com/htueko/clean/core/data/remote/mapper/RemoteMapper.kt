package com.htueko.clean.core.data.remote.mapper

import com.htueko.clean.core.data.remote.dto.UserDto
import com.htueko.clean.core.domain.model.User
import com.htueko.clean.core.domain.model.status.ResultOf
import javax.inject.Singleton

/**
 * to convert from data transfer object of data layer to model object of domain layer
 */
@Singleton
class RemoteMapper {

    fun toDomainModel(response: ResultOf<List<UserDto>>): ResultOf<List<User>> {
        return when (response) {
            is ResultOf.ApiError -> ResultOf.ApiError(response.message)
            is ResultOf.NetworkError -> ResultOf.NetworkError(response.throwable)
            is ResultOf.Success -> ResultOf.Success(mapFromDtoToModelList(data = response.data))
        }
    }

    private fun mapFromDtoToModelList(data: List<UserDto>): List<User> {
        return data.map { userDto ->
            User(
                name = userDto.name,
                email = userDto.email,
                id = userDto.id.toLong()
            )
        }
    }

    fun toUserModel(response: ResultOf<UserDto>): ResultOf<User> {
        return when (response) {
            is ResultOf.ApiError -> ResultOf.ApiError(response.message)
            is ResultOf.NetworkError -> ResultOf.NetworkError(response.throwable)
            is ResultOf.Success -> {
                val user = User(
                    name = response.data.name,
                    email = response.data.email,
                    id = response.data.id.toLong()
                )
                ResultOf.Success(user)
            }
        }
    }
}