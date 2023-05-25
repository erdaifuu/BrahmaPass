package com.example.brahmapassv3.screens.settings

import com.example.brahmapassv3.R
import com.example.brahmapassv3.SETTINGS_SCREEN
import com.example.brahmapassv3.TEACHER_SCREEN
import com.example.brahmapassv3.common.snackbar.SnackbarManager

import androidx.compose.runtime.mutableStateOf
import com.example.brahmapassv3.LOGIN_SCREEN
import com.example.brahmapassv3.SETTINGS_SCREEN
import com.example.brahmapassv3.TEACHER_SCREEN
import com.example.brahmapassv3.R.string as AppText
import com.example.brahmapassv3.common.ext.isValidEmail
import com.example.brahmapassv3.model.service.AccountService
import com.example.brahmapassv3.model.service.LogService
import com.example.brahmapassv3.screens.MakeItSoViewModel
import com.example.brahmapassv3.screens.login.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val accountService: AccountService,
    logService: LogService
) : MakeItSoViewModel(logService) {


}