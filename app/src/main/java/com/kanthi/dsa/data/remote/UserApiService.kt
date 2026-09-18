package com.kanthi.dsa.data.remote

import com.kanthi.dsa.data.model.UserResponse
import retrofit2.http.GET

/** Describes the user endpoint implemented by Retrofit. */
interface UserApiService {

    /** Fetches the list of users from the server. */
    @GET("users")
    suspend fun getUsers(): UserResponse

}
