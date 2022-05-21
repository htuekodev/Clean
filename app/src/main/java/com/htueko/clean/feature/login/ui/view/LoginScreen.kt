package com.htueko.clean.feature.login.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.htueko.clean.core.presentation.event.CommonUiEvent
import com.htueko.clean.feature.login.ui.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onLoginClicked: (String) -> Unit,
) {
    val viewState = viewModel.viewState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { uiEvent ->
            when (uiEvent) {
                is CommonUiEvent.ShowSnackBar -> {
                    // nothing to do here
                }
                CommonUiEvent.PopBackStack -> {
                    // nothing to do here
                }
                is CommonUiEvent.NavigateWithString -> {
                    onLoginClicked(uiEvent.name)
                }
            }
        }
    }

    LoginContent(
        viewState = viewState.value,
        onNameChanged = viewModel::nameChanged,
        onEmailChanged = viewModel::emailChanged,
        onPasswordChanged = viewModel::passwordChanged,
        onLoginClicked = viewModel::onSubmitClicked,
    )
}