package com.htueko.clean.feature.login.ui.state

import com.htueko.clean.core.presentation.util.UiText

data class LoginViewState(
    val isLoading: Boolean = false,
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val nameErrorMessage: UiText? = null,
    val emailErrorMessage: UiText? = null,
    val passwordErrorMessage: UiText? = null,
    val loginErrorMessage: UiText? = null,
)