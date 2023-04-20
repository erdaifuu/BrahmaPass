package com.example.brahmapassv3.screens.home

import com.example.brahmapassv3.screens.home.StudentHomeUiState


import androidx.compose.runtime.mutableStateOf
import com.example.brahmapassv3.CONFIRMATION1_SCREEN
import com.example.brahmapassv3.STUDENT_SCREEN
import com.example.brahmapassv3.R.string as AppText
import com.example.brahmapassv3.common.ext.isValidEmail
import com.example.brahmapassv3.common.ext.isValidID
import com.example.brahmapassv3.common.snackbar.SnackbarManager
import com.example.brahmapassv3.model.service.AccountService
import com.example.brahmapassv3.model.service.LogService
import com.example.brahmapassv3.screens.MakeItSoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StudentHomeViewModel @Inject constructor(
    private val accountService: AccountService,
    logService: LogService
) : MakeItSoViewModel(logService) {
    var uiState = mutableStateOf(StudentHomeUiState())
        private set
    private val id
        get () = uiState.value.id

    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(id = newValue)
    }


    fun onCreateHallpassClick(openAndPopUp: (String, String) -> Unit) {
        if (!isValidID(uiState.value.id)) {
            SnackbarManager.showMessage(AppText.id_error)
            return
        }
        launchCatching {
            openAndPopUp(CONFIRMATION1_SCREEN, STUDENT_SCREEN)
        }

    }

}