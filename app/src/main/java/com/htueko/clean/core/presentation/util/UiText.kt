package com.htueko.clean.core.presentation.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * This is a sealed class that contains all of the different ways text can be presented to the UI.
 */
sealed class UiText {

    data class StringText(val value: String) : UiText()

    data class ResourceText(@StringRes val value: Int) : UiText()
}

/**
 * Evaluates the value of this [UiText] based on its type.
 *
 * @param[context] If necessary, use this to evaluate a string resource.
 */
fun UiText.getString(context: Context): String {
    return when (this) {
        is UiText.StringText -> this.value
        is UiText.ResourceText -> context.getString(this.value)
    }
}

/**
 * A helper function that allows to get strings from a [Composable] context.
 */
@Composable
fun UiText.getString(): String {
    return this.getString(LocalContext.current)
}
