package com.kanthi.dsa.presenter.userscreen

import com.kanthi.dsa.domain.model.User

/** States the user screens can display while loading users. */
sealed interface UiState{

    /** A user request is in progress. */
    object Loading: UiState

    /** Users were loaded successfully. */
    data class Success(val response: List<User>) : UiState

    /** A user request failed with a displayable message. */
    data class Error(val errorMessage: String) : UiState
}
