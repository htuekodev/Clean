package com.htueko.clean.feature.login.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.htueko.clean.core.domain.model.User
import com.htueko.clean.core.domain.usecase.RegisterUserUseCase
import com.htueko.clean.core.presentation.event.CommonUiEvent
import com.htueko.clean.feature.login.domain.usecase.ValidateEmail
import com.htueko.clean.feature.login.domain.usecase.ValidateName
import com.htueko.clean.feature.login.domain.usecase.ValidatePassword
import com.htueko.clean.feature.login.domain.usecase.ValidationResult
import com.htueko.clean.feature.login.ui.state.LoginViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: RegisterUserUseCase,
) : ViewModel() {

    // to perform common ui operation.
    private val _uiEvent = Channel<CommonUiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private val _viewState: MutableStateFlow<LoginViewState> =
        MutableStateFlow(LoginViewState())
    val viewState: StateFlow<LoginViewState> = _viewState.asStateFlow()

    fun nameChanged(name: String) {
        _viewState.update { it.copy(name = name) }
    }

    fun emailChanged(email: String) {
        _viewState.update { it.copy(email = email) }
    }

    fun passwordChanged(password: String) {
        _viewState.update { it.copy(password = password) }
    }

    fun onSubmitClicked() {
        val currentViewState = _viewState.value
        val name: ValidationResult = ValidateName.execute(currentViewState.name)
        val email: ValidationResult = ValidateEmail.execute(currentViewState.email)
        val password: ValidationResult = ValidatePassword.execute(currentViewState.password)

        val hasError = listOf(name, email, password)
            .any { !it.isSuccess }
        if (hasError) {
            _viewState.update {
                it.copy(
                    nameErrorMessage = name.errorMessage,
                    emailErrorMessage = email.errorMessage,
                    passwordErrorMessage = password.errorMessage,
                )
            }
            return
        }

        viewModelScope.launch {
            _viewState.update { it.copy(isLoading = true) }
            loginUseCase(
                User(
                    name = _viewState.value.name,
                    email = _viewState.value.email,
                )
            )
        }
        // to navigate to detail screen with user name
        sendUiEvent(CommonUiEvent.NavigateWithString(_viewState.value.name))
    }

    private fun sendUiEvent(event: CommonUiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

}