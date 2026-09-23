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

    // Mock the dependency while keeping the ViewModel behavior real.
    val getUsersUseCase = mockk<GetUsersUseCase>()

    private val testDispatcher = UnconfinedTestDispatcher()

    val viewModel = UserViewModel(getUsersUseCase)

    // @Before runs for each test. A local JVM has no Android Main dispatcher,
    // so give viewModelScope a test dispatcher before creating the ViewModel.
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    // @After restores global Main so this test does not affect other tests.
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

        // coEvery stubs the suspend invoke() operator used by getUsers().
        coEvery { getUsersUseCase() } returns users

        // UnconfinedTestDispatcher starts the launched coroutine immediately.
        viewModel.getUsers()

        // assertEquals(expected, actual) checks the public StateFlow's current value.
        assertEquals(UiState.Success(users), viewModel.uiState.value)

        coVerify(exactly = 1) { getUsersUseCase() }
    }

    @Test
    fun `getUsers updates UI state to error when use case throws`() = runTest {
        val errorMessage = "No internet connection"

        coEvery { getUsersUseCase() } throws Exception(errorMessage)

        viewModel.getUsers()

        assertEquals(UiState.Error(errorMessage), viewModel.uiState.value)
        coVerify(exactly = 1) { getUsersUseCase() }
    }

}
