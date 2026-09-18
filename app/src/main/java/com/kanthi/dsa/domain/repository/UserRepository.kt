package com.kanthi.dsa.domain.repository

import com.kanthi.dsa.domain.model.User

/** Domain contract for loading users, independent of the API implementation. */
interface UserRepository {

    /** Loads users or throws when loading fails. */
    suspend fun getUsers(): List<User>

}
