package com.htueko.clean.core.presentation.component

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasAnyChild
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.htueko.clean.core.presentation.theme.CleanTheme
import org.junit.Rule
import org.junit.Test

class CleanOutlineButtonTest {

    @get:Rule
    val composeTextRule = createComposeRule()

    @Test
    fun renderOutlineButtonWithIconAndText() {
        composeTextRule.setContent {
            CleanTheme {
                CleanOutlineButton(text = "Clean", onClick = {})
            }
        }

        composeTextRule
            .onNodeWithTag(TestTag.ButtonTag.cleanOutlineButtonTag)
            .assertIsDisplayed()
            .assert(hasText("Clean"))
            .assert(hasAnyChild(hasTestTag(TestTag.IconTag.cleanOutlineButtonIconTag)))
            .assert(hasAnyChild(hasTestTag(TestTag.TextTag.cleanOutlineButtonTextTag)))

    }

}