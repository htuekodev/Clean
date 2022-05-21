package com.htueko.clean.core.presentation.component

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.htueko.clean.core.presentation.theme.CleanTheme

/**
 * Outline button with icon.
 *
 * @param [modifier] modifier to passed down from parent.
 * @param [borderWidth] width of the border, default is 1 dp.
 * @param [borderColour] colour of the border, default is primary colour.
 * @param [imageVector] icon for the button, default is heart outline.
 * @param [contentDescription] description of the icon.
 * @param [iconPadding] end padding of the icon.
 * @param [text] text for the button.
 * @param [onClick] callback when the button is clicked.
 */
@Composable
fun CleanOutlineButton(
    modifier: Modifier = Modifier,
    borderWidth: Dp = 1.dp,
    borderColour: Color = MaterialTheme.colors.primary,
    imageVector: ImageVector = Icons.Outlined.FavoriteBorder,
    contentDescription: String? = null,
    iconPadding: Dp = 4.dp,
    text: String,
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        border = BorderStroke(borderWidth, borderColour),
        modifier = modifier.testTag(TestTag.ButtonTag.cleanOutlineButtonTag),
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            modifier = Modifier
                .padding(end = iconPadding)
                .testTag(TestTag.IconTag.cleanOutlineButtonIconTag)
        )
        Text(text = text, modifier = modifier.testTag(TestTag.TextTag.cleanOutlineButtonTextTag))
    }
}

/**
 * preview of the outline button on Dark and Light Theme
 */
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
private fun TextFieldPrimaryPreview() {
    CleanTheme {
        Surface {
            CleanOutlineButton(
                text = "Testing",
                onClick = {},
            )
        }
    }
}