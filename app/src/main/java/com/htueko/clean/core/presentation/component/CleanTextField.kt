package com.htueko.clean.core.presentation.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.htueko.clean.R
import com.htueko.clean.core.presentation.theme.CleanTheme


/**
 * Custom text field for primary usage
 *
 * @param [modifier] An optional modifier for this button
 * @param [text] Text of the text field like hint
 * @param [labelText] Label of this text field
 * @param [onTextChanged] lambda operation when the user typed string
 * @param [hasError] to show the error message or not.
 * @param [errorMessage] the message to show about the error.
 * @param [keyboardType] type of the keyboard. default is Text
 * @param [imeAction] how the enter key react. default is next.
 */
@Composable
fun CleanTextField(
    modifier: Modifier = Modifier,
    text: String,
    isSingleLine: Boolean = true,
    maxLines: Int = 1,
    labelText: String,
    onTextChanged: (String) -> Unit,
    hasError: Boolean = false,
    errorMessage: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
) {
    Column(
        modifier = modifier.testTag(TestTag.TextFieldTag.cleanTextFieldParentTag)
    ) {
        // height of the text field
        val textFieldHeight = dimensionResource(id = R.dimen.text_field_height)
        // shape of the text field
        val textFieldShape = MaterialTheme.shapes.medium
        OutlinedTextField(
            value = text,
            singleLine = isSingleLine,
            maxLines = maxLines,
            label = {
                Text(text = labelText)
            },
            shape = textFieldShape,
            onValueChange = onTextChanged,
            modifier = modifier
                .fillMaxWidth()
                .height(textFieldHeight)
                .testTag(TestTag.TextFieldTag.cleanTextFieldTag),
            visualTransformation = visualTransformation,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            )
        )
        // error message
        if (hasError) {
            Text(
                text = errorMessage!!,
                color = MaterialTheme.colors.error,
                modifier = Modifier
                    .padding(
                        top = 4.dp,
                        start = 16.dp,
                    ),
            )
        }
    }
}

/**
 * preview of text field on Dark and Light Theme
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
            CleanTextField(
                text = "Text Field",
                labelText = "Label",
                onTextChanged = {},
            )
        }
    }
}