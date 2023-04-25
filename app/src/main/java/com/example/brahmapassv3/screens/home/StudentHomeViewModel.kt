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
import com.google.firebase.Timestamp
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.NumberFormatException
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class StudentHomeViewModel @Inject constructor(
    private val accountService: AccountService,
    logService: LogService,
    private val storageService: StorageService,
) : MakeItSoViewModel(logService) {
    val exit = mutableStateOf(Exit())

    fun onReasonChange(newValue: String) {
        exit.value = exit.value.copy(reason = newValue)
    }
        fun onIdChange(newValue: String) {
            try {
                exit.value = exit.value.copy(studentId = newValue.toInt())
            } catch (_: NumberFormatException) {
                exit.value = exit.value.copy(studentId = 0)
            }
        }

        private fun setNewTimestamp() {
            exit.value = exit.value.copy(time = Timestamp.now())
        }


        fun onCreateHallPassClick(openAndPopUp: (String, String) -> Unit) {
            launchCatching {
                setNewTimestamp()
                if(exit.value.reason.isBlank()) {
                    exit.value = exit.value.copy(reason = "Bathroom");
                }

                val editedExit = exit.value
                if (editedExit.id.isBlank()) {
                    storageService.save(editedExit)
                } else {
                    storageService.update(editedExit)
                }
                openAndPopUp(CONFIRMATION1_SCREEN, STUDENT_SCREEN)
            }
        }
    }