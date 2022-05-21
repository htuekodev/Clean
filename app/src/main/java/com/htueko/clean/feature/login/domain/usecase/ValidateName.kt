package com.htueko.clean.feature.login.domain.usecase

import com.htueko.clean.core.presentation.util.UiText

object ValidateName {

    fun execute(name: String): ValidationResult {
        if (name.isBlank()) {
            return ValidationResult(
                isSuccess = false,
                errorMessage = UiText.StringText("The name can't be blank")
            )
        }
        return ValidationResult(
            isSuccess = true
        )
    }
}