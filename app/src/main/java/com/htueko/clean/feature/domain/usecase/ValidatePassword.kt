package com.htueko.clean.feature.domain.usecase

import com.htueko.clean.core.presentation.util.UiText

class ValidatePassword {

    fun execute(password: String): ValidationResult {
        if (password.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringText("The password needs to consist of at least 8 characters")
            )
        }
        val containsLettersAndDigits = password.any { it.isDigit() } &&
                password.any { it.isLetter() }
        if (!containsLettersAndDigits) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringText("The password needs to contain at least one letter and digit")
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}