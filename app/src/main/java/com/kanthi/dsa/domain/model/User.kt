package com.kanthi.dsa.domain.model

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val username: String = "",
    val website: String = "",
    val address: UserAddress = UserAddress(),
    val companyName: String = "",
    val companyCatchPhrase: String = "",
    val companyBs: String = ""
)

data class UserAddress(
    val street: String = "",
    val suite: String = "",
    val city: String = "",
    val zipcode: String = "",
    val latitude: String = "",
    val longitude: String = ""
)
