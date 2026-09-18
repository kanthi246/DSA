package com.kanthi.dsa.data.model

/** Address fields as returned by the API. */
data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)
