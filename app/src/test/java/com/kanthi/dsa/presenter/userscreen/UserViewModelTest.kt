package com.kanthi.dsa.presenter.userscreen

import com.kanthi.dsa.core.Resource
import com.kanthi.dsa.domain.model.User
import com.kanthi.dsa.domain.repository.UserRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getUsers updates UI state to success when repository emits users`() = runTest {
        val users = listOf(
            User(
                id = 1,
                name = "Kanthi",
                email = "kanthi@example.com",
                phone = "9492289246"
            )
        )
        val repository = mockk<UserRepository>()

        every { repository.getUsers() } returns flowOf(
            Resource.Loading,
            Resource.Success(users)
        )

        val viewModel = UserViewModel(repository)

        viewModel.getUsers()

        assertEquals(UiState.Success(users), viewModel.uiState.value)
        verify(exactly = 1) { repository.getUsers() }
    }

    @Test
    fun `getUsers updates UI state to error when repository emits error`() = runTest {
        val errorMessage = "No internet connection"
        val repository = mockk<UserRepository>()

        every { repository.getUsers() } returns flowOf(
            Resource.Loading,
            Resource.Error(errorMessage)
        )

        val viewModel = UserViewModel(repository)

        viewModel.getUsers()

        assertEquals(UiState.Error(errorMessage), viewModel.uiState.value)
        verify(exactly = 1) { repository.getUsers() }
    }

}
