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

class CleanProgressIndicatorTest {

    @get:Rule
    val composeTextRule = createComposeRule()

    @Test
    fun renderProgressIndicator() {
        composeTextRule.setContent {
            CleanTheme {
                CleanProgressIndicator()
            }
        }

        composeTextRule
            .onNodeWithTag(TestTag.UtilTag.cleanProgressIndicatorTag)
            .assertIsDisplayed()
            .assert(hasTestTag(TestTag.UtilTag.cleanProgressIndicatorTag))

    }

}