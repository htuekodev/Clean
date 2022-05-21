package com.htueko.clean.feature.login.domain.usecase

import com.htueko.clean.core.presentation.util.UiText

object ValidatePassword {

    fun execute(password: String): ValidationResult {
        if (password.length < 8) {
            return ValidationResult(
                isSuccess = false,
                errorMessage = UiText.StringText("The password needs to consist of at least 8 characters")
            )
        }
        val containsLettersAndDigits = password.any { it.isDigit() } &&
                password.any { it.isLetter() }
        if (!containsLettersAndDigits) {
            return ValidationResult(
                isSuccess = false,
                errorMessage = UiText.StringText("The password needs to contain at least one letter and digit")
            )
        }
        return ValidationResult(
            isSuccess = true
        )
    }
}