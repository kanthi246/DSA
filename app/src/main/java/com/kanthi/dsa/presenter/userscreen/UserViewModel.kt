package com.kanthi.dsa.presenter.userscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanthi.dsa.core.Resource
import com.kanthi.dsa.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun getUsers() {
        viewModelScope.launch {
            getUsersUseCase().collect { resource ->
                _uiState.value = when (resource) {
                    is Resource.Loading -> UiState.Loading

                    is Resource.Success -> UiState.Success(resource.data)

                    is Resource.Error -> UiState.Error(resource.message)
                }
            }
        }
    }
}
