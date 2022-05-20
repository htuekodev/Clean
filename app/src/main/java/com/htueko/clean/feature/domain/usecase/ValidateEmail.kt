package com.htueko.clean.feature.domain.usecase

import android.util.Patterns
import com.htueko.clean.core.presentation.util.UiText

class ValidateEmail {

    fun execute(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringText("This email is blank")
            )
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringText("This email is invalid")
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}