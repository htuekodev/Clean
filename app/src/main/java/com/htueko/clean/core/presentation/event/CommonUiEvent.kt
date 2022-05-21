package com.htueko.clean.core.presentation.event

/**
 * a model that represented everything that user can do on most of the screen.
 */
sealed class CommonUiEvent {
    /**
     * to show snack bar
     */
    object ShowSnackBar : CommonUiEvent()

    /**
     * to pop backstack
     */
    object PopBackStack : CommonUiEvent()

    /**
     * navigate and to send data (string)
     */
    data class NavigateWithString(val name: String) : CommonUiEvent()
}