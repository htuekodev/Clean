package com.htueko.clean.feature.domain.usecase

import com.htueko.clean.core.presentation.util.UiText

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: UiText? = null
)
