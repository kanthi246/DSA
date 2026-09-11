package com.kanthi.dsa.data.remote

import com.kanthi.dsa.data.model.UserResponse
import retrofit2.http.GET

interface UserApiService {

    @GET("users")
    suspend fun getUsers(): UserResponse

}
