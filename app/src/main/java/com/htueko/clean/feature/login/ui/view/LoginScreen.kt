package com.htueko.clean.feature.login.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.htueko.clean.feature.login.ui.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onLoginClicked: (String) -> Unit,
) {
    val viewState = viewModel.viewState.collectAsState()

    LoginContent(
        viewState = viewState.value,
        onNameChanged = viewModel::nameChanged,
        onEmailChanged = viewModel::emailChanged,
        onPasswordChanged = viewModel::passwordChanged,
        onLoginClicked = viewModel::onSubmitClicked,
    )
}