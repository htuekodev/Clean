package com.htueko.clean.feature.login.domain.usecase

import com.htueko.clean.core.presentation.util.UiText

data class ValidationResult(
    val isSuccess: Boolean,
    val errorMessage: UiText? = null
)
