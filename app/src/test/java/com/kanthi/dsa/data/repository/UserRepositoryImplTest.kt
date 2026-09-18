package com.kanthi.dsa.data.repository

import com.kanthi.dsa.data.model.Address
import com.kanthi.dsa.data.model.Company
import com.kanthi.dsa.data.model.Geo
import com.kanthi.dsa.data.model.UserResponse
import com.kanthi.dsa.data.model.UserResponseItem
import com.kanthi.dsa.data.remote.UserApiService
import com.kanthi.dsa.domain.model.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UserRepositoryImplTest {

    private val apiService = mockk<UserApiService>()
    private val repository = UserRepositoryImpl(apiService)

    private lateinit var userResponse: UserResponse
    private lateinit var expectedUsers: List<User>

    @Before
    fun setUp() {
        userResponse = UserResponse().apply {
            add(
                UserResponseItem(
                    id = 1,
                    name = "Kanthi",
                    username = "kanthi",
                    email = "kanthi@example.com",
                    phone = "9492289246",
                    website = "kanthi.dev",
                    address = Address(
                        street = "Main Street",
                        suite = "Apt 1",
                        city = "Hyderabad",
                        zipcode = "500001",
                        geo = Geo(lat = "17.3850", lng = "78.4867")
                    ),
                    company = Company(
                        name = "Example Co.",
                        catchPhrase = "Build great apps",
                        bs = "testing"
                    )
                )
            )
        }
        expectedUsers = listOf(
            User(
                id = 1,
                name = "Kanthi",
                username = "kanthi",
                email = "kanthi@example.com",
                phone = "9492289246",
                website = "kanthi.dev",
                address = com.kanthi.dsa.domain.model.UserAddress(
                    street = "Main Street",
                    suite = "Apt 1",
                    city = "Hyderabad",
                    zipcode = "500001",
                    latitude = "17.3850",
                    longitude = "78.4867"
                ),
                companyName = "Example Co.",
                companyCatchPhrase = "Build great apps",
                companyBs = "testing"
            )
        )
    }

    @Test
    fun `getUsers returns mapped API data when request succeeds`() = runTest {
        coEvery { apiService.getUsers() } returns userResponse

        assertEquals(expectedUsers, repository.getUsers())

        coVerify(exactly = 1) { apiService.getUsers() }
    }

    @Test
    fun `getUsers propagates error when request fails`() = runTest {
        coEvery { apiService.getUsers() } throws Exception("No internet connection")

        val error = requireNotNull(runCatching { repository.getUsers() }.exceptionOrNull())
        assertEquals("No internet connection", error.message)

        coVerify(exactly = 1) { apiService.getUsers() }
    }
}
