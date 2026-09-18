package com.kanthi.dsa.presenter.userscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanthi.dsa.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
/** Holds the current loading, success, or error state for user screens. */
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    /** Starts a user request in the ViewModel's lifecycle scope. */
    fun getUsers() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                _uiState.value = UiState.Success(getUsersUseCase())
            } catch (e: CancellationException) {
                // Cancellation means the coroutine was stopped; do not display it as a request error.
                throw e
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Something went wrong")
            }
        }
    }
}
