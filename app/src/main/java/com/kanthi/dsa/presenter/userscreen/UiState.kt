package com.kanthi.dsa.presenter.userscreen

import com.kanthi.dsa.domain.model.User

sealed interface UiState{

    object Loading: UiState

    data class Success(val response: List<User>) : UiState

    data class Error(val errorMessage: String) : UiState
}