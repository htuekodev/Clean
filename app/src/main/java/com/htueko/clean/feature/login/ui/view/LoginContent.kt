package com.htueko.clean.feature.login.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.htueko.clean.R
import com.htueko.clean.core.presentation.component.CleanOutlineButton
import com.htueko.clean.core.presentation.component.CleanProgressIndicator
import com.htueko.clean.core.presentation.component.CleanTextField
import com.htueko.clean.core.presentation.component.VerticalSpacer
import com.htueko.clean.core.presentation.util.getString
import com.htueko.clean.feature.login.ui.state.LoginViewState

private const val APP_LOGO_WIDTH_PERCENTAGE = 0.75F

@Composable
fun LoginContent(
    viewState: LoginViewState,
    onNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        // padding for the whole screen
        val screenPadding = dimensionResource(id = R.dimen.padding_screen)
        // A container that filled the whole screen width and height
        LoginContentColumn(
            screenPadding,
            viewState,
            onNameChanged,
            onEmailChanged,
            onPasswordChanged,
            onLoginClicked,
        )

        if (viewState.isLoading) {
            // Progress bar at the center of the screen
            CleanProgressIndicator(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.Center),
            )
        }
    }
}

@Composable
private fun LoginContentColumn(
    screenPadding: Dp,
    viewState: LoginViewState,
    onNameChanged: (String) -> Unit,
    onEmailAddressChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(screenPadding),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = contentPadding.calculateStartPadding(
                    LocalLayoutDirection.current,
                ),
                end = contentPadding.calculateEndPadding(
                    LocalLayoutDirection.current,
                ),
            )
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        VerticalSpacer(height = contentPadding.calculateTopPadding())

        AppLogo(
            modifier = Modifier
                .padding(vertical = 88.dp),
        )

        // Name TextFiled
        NameTextField(
            text = viewState.name,
            hasError = viewState.nameErrorMessage != null,
            onTextChange = onNameChanged,
            errorMessage = viewState.nameErrorMessage?.getString()
        )

        VerticalSpacer(height = 24.dp)

        // Email address TextField
        EmailTextField(
            text = viewState.email,
            hasError = viewState.emailErrorMessage != null,
            onTextChange = onEmailAddressChanged,
            errorMessage = viewState.emailErrorMessage?.getString(),
        )

        VerticalSpacer(height = 24.dp)

        // Password TextField
        PasswordTextField(
            text = viewState.password,
            hasError = viewState.passwordErrorMessage != null,
            onTextChange = onPasswordChanged,
            errorMessage = viewState.passwordErrorMessage?.getString(),
        )

        VerticalSpacer(height = 12.dp)

        // Sign up button
        SignUpButton(
            onClick = onLoginClicked,
        )

        VerticalSpacer(height = contentPadding.calculateBottomPadding())
    }
}

@Composable
private fun AppLogo(
    modifier: Modifier = Modifier
) {
    Image(
        painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = stringResource(R.string.app_name),
        modifier = modifier
            .fillMaxWidth(APP_LOGO_WIDTH_PERCENTAGE),
    )
}

@Composable
private fun NameTextField(
    text: String,
    hasError: Boolean,
    onTextChange: (String) -> Unit,
    errorMessage: String? = null,
) {
    CleanTextField(
        text = text,
        hasError = hasError,
        labelText = stringResource(id = R.string.text_name),
        onTextChanged = onTextChange,
        errorMessage = errorMessage,
    )
}

@Composable
fun EmailTextField(
    text: String,
    hasError: Boolean,
    onTextChange: (String) -> Unit,
    errorMessage: String? = null,
) {
    CleanTextField(
        text = text,
        hasError = hasError,
        labelText = stringResource(id = R.string.text_email),
        onTextChanged = onTextChange,
        errorMessage = errorMessage,
        keyboardType = KeyboardType.Email,
    )
}

@Composable
private fun PasswordTextField(
    text: String,
    hasError: Boolean,
    onTextChange: (String) -> Unit,
    errorMessage: String? = null,
) {
    CleanTextField(
        text = text,
        hasError = hasError,
        labelText = stringResource(id = R.string.text_password),
        onTextChanged = onTextChange,
        errorMessage = errorMessage,
        keyboardType = KeyboardType.Password,
        imeAction = ImeAction.Done,
    )
}


@Composable
private fun LoginInErrorText(errorMessage: String) {
    Text(
        text = errorMessage,
        color = MaterialTheme.colors.error,
    )
}

@Composable
private fun SignUpButton(
    onClick: () -> Unit,
) {
    CleanOutlineButton(
        text = stringResource(id = R.string.text_login),
        onClick = onClick,
    )
}
