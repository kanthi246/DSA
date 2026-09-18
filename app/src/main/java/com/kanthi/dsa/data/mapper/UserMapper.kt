package com.kanthi.dsa.data.mapper

import com.kanthi.dsa.data.model.UserResponseItem
import com.kanthi.dsa.domain.model.User
import com.kanthi.dsa.domain.model.UserAddress

/** Converts one API response item into a user used by the UI. */
fun UserResponseItem.toUser(): User {
    return User(
        id = id,
        name = name,
        email = email,
        phone = phone,
        username = username,
        website = website,
        address = UserAddress(
            street = address.street,
            suite = address.suite,
            city = address.city,
            zipcode = address.zipcode,
            latitude = address.geo.lat,
            longitude = address.geo.lng
        ),
        companyName = company.name,
        companyCatchPhrase = company.catchPhrase,
        companyBs = company.bs
    )
}
