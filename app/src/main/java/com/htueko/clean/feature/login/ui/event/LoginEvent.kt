package com.htueko.clean.feature.login.ui.event

/**
 * These are the possible event that can happened on login screen.
 */
sealed class LoginEvent {
    data class EmailChanged(val email: String) : LoginEvent()
    data class PasswordChanged(val password: String) : LoginEvent()
    data class NameChanged(val name: String) : LoginEvent()
    object ClickSubmitButton : LoginEvent()
}