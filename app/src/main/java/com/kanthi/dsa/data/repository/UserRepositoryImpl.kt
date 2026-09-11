package com.kanthi.dsa.data.repository

import com.kanthi.dsa.core.Resource
import com.kanthi.dsa.data.mapper.toUser
import com.kanthi.dsa.data.remote.UserApiService
import com.kanthi.dsa.domain.model.User
import com.kanthi.dsa.domain.repository.UserRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApiService: UserApiService
) : UserRepository {

    override fun getUsers(): Flow<Resource<List<User>>> = flow {
        emit(Resource.Loading)
        try {
            val response = userApiService.getUsers()
            emit(Resource.Success(response.map { it.toUser() }))
        } catch (exception: CancellationException) {
            throw exception
        } catch (exception: Exception) {
            emit(
                Resource.Error(
                    message = exception.message ?: "Unknown error"
                )
            )
        }
    }
}
