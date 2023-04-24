package com.example.brahmapassv3.screens.home

import com.example.brahmapassv3.screens.home.StudentHomeUiState


import androidx.compose.runtime.mutableStateOf
import com.example.brahmapassv3.CONFIRMATION1_SCREEN
import com.example.brahmapassv3.STUDENT_SCREEN
import com.example.brahmapassv3.R.string as AppText
import com.example.brahmapassv3.common.ext.isValidEmail
import com.example.brahmapassv3.common.ext.isValidID
import com.example.brahmapassv3.common.snackbar.SnackbarManager
import com.example.brahmapassv3.model.Exit
import com.example.brahmapassv3.model.service.AccountService
import com.example.brahmapassv3.model.service.LogService
import com.example.brahmapassv3.model.service.StorageService
import com.example.brahmapassv3.screens.MakeItSoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeacherHomeViewModel @Inject constructor(
    private val accountService: AccountService,
    logService: LogService,
    private val storageService: StorageService,
) : MakeItSoViewModel(logService) {

}