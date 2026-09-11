package com.kanthi.dsa.domain.repository

import com.kanthi.dsa.core.Resource
import com.kanthi.dsa.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUsers(): Flow<Resource<List<User>>>

}
