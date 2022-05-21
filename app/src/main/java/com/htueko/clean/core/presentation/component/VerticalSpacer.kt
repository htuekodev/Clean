package com.htueko.clean.core.presentation.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.Dp

/**
 * Vertical custom spacer
 *
 * @param [height] Height of the vertical spacer
 */
@Composable
fun VerticalSpacer(height: Dp) {
    Spacer(
        modifier = Modifier
            .height(height = height)
            .testTag(TestTag.UtilTag.cleanVerticalSpacerTag)
    )
}