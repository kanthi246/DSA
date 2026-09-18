package com.kanthi.dsa.data.repository

import com.kanthi.dsa.data.mapper.toUser
import com.kanthi.dsa.data.remote.UserApiService
import com.kanthi.dsa.domain.model.User
import com.kanthi.dsa.domain.repository.UserRepository
import javax.inject.Inject

/** Fetches API users and converts them to domain models. */
class UserRepositoryImpl @Inject constructor(
    private val userApiService: UserApiService
) : UserRepository {
    /** Returns mapped users; failures and cancellation propagate to the caller. */
    override suspend fun getUsers(): List<User> {
        val result = userApiService.getUsers()
        return result.map { it.toUser() }
    }
}
