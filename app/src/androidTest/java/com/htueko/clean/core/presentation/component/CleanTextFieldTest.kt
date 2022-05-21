package com.htueko.clean.core.presentation.component

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasAnyChild
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.htueko.clean.core.presentation.theme.CleanTheme
import org.junit.Rule
import org.junit.Test

class CleanTextFieldTest {

    @get:Rule
    val composeTextRule = createComposeRule()

    @Test
    fun renderTextWithRoundCornerShape() {
        composeTextRule.setContent {
            CleanTheme {
                CleanTextField(
                    text = "testText",
                    labelText = "labelText",
                    onTextChanged = {},
                )
            }
        }

        composeTextRule
            .onNodeWithTag(TestTag.TextFieldTag.cleanTextFieldParentTag)
            .assertIsDisplayed()
            .assert(hasAnyChild(hasTestTag(TestTag.TextFieldTag.cleanTextFieldTag)))
            .assert(
                hasAnyChild(
                    hasTestTag(TestTag.TextFieldTag.cleanTextFieldTag)
                )
            )

    }

}