package com.htueko.clean.core.presentation.component

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.unit.dp
import com.htueko.clean.core.presentation.theme.CleanTheme
import org.junit.Rule
import org.junit.Test

class VerticalSpacerTest {
    @get:Rule
    val composeTextRule = createComposeRule()

    @Test
    fun renderVerticalSpacer() {
        composeTextRule.setContent {
            CleanTheme {
                VerticalSpacer(height = 12.dp)
            }
        }

        composeTextRule
            .onNodeWithTag(TestTag.UtilTag.cleanVerticalSpacerTag)
            .assertIsDisplayed()
            .assert(hasTestTag(TestTag.UtilTag.cleanVerticalSpacerTag))

    }
}