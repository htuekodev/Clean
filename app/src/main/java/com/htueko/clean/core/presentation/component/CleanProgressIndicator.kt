package com.htueko.clean.core.presentation.component

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

/**
 * A customisable progress indicator.
 *
 * @param [modifier] modifier to passed down from parent.
 * @param [color] colour of the progress indicator, default is primary colour.
 * @param [strokeWidth] width of the border, default is 4 dp.
 */
@Composable
fun CleanProgressIndicator(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.primary,
    strokeWidth: Dp = ProgressIndicatorDefaults.StrokeWidth,
) {
    CircularProgressIndicator(
        modifier, color, strokeWidth
    )
}