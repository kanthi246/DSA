package com.kanthi.dsa.data.model

/** One user record in the API response. */
data class UserResponseItem(
    val address: Address,
    val company: Company,
    val email: String = "kanthikirann22@gmail.com",
    val id: Int,
    val name: String = "Kanthi",
    val phone: String ="9492289246",
    val username: String,
    val website: String
)
