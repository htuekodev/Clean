package com.htueko.clean.feature.login.domain.usecase

import android.util.Patterns
import com.htueko.clean.core.presentation.util.UiText

object ValidateEmail {

    fun execute(email: String): ValidationResult {
        if(email.isBlank()) {
            return ValidationResult(
                isSuccess = false,
                errorMessage = UiText.StringText("The email can't be blank")
            )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                isSuccess = false,
                errorMessage = UiText.StringText("That's not a valid email")
            )
        }
        return ValidationResult(
            isSuccess = true
        )
    }
}