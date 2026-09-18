package com.kanthi.dsa.presenter.userscreen

import com.kanthi.dsa.domain.model.User
import com.kanthi.dsa.domain.usecase.GetUsersUseCase
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.coVerify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
    fun `getUsers updates UI state to success when use case returns users`() = runTest {
        val users = listOf(
            User(
                id = 1,
                name = "Kanthi",
                email = "kanthi@example.com",
                phone = "9492289246"
            )
        )
        val getUsersUseCase = mockk<GetUsersUseCase>()

        coEvery { getUsersUseCase() } returns users

        val viewModel = UserViewModel(getUsersUseCase)

        viewModel.getUsers()

        assertEquals(UiState.Success(users), viewModel.uiState.value)
        coVerify(exactly = 1) { getUsersUseCase() }
    }

    @Test
    fun `getUsers updates UI state to error when use case throws`() = runTest {
        val errorMessage = "No internet connection"
        val getUsersUseCase = mockk<GetUsersUseCase>()

        coEvery { getUsersUseCase() } throws Exception(errorMessage)

        val viewModel = UserViewModel(getUsersUseCase)

        viewModel.getUsers()

        assertEquals(UiState.Error(errorMessage), viewModel.uiState.value)
        coVerify(exactly = 1) { getUsersUseCase() }
    }

}
