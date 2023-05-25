package com.example.brahmapassv3.screens.student_home


import androidx.compose.runtime.mutableStateOf
import com.example.brahmapassv3.CONFIRMATION1_SCREEN
import com.example.brahmapassv3.R
import com.example.brahmapassv3.STUDENT_SCREEN
import com.example.brahmapassv3.common.snackbar.SnackbarManager
import com.example.brahmapassv3.model.Exit
import com.example.brahmapassv3.model.service.AccountService
import com.example.brahmapassv3.model.service.LogService
import com.example.brahmapassv3.model.service.StorageService
import com.example.brahmapassv3.screens.MakeItSoViewModel
import com.google.firebase.Timestamp
import dagger.hilt.android.lifecycle.HiltViewModel
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
            if (newValue.length == 6) {
                exit.value = exit.value.copy(studentId = newValue.toIntOrNull())
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
                if (editedExit.studentId.toString().length == 6) {
                    openAndPopUp(CONFIRMATION1_SCREEN, STUDENT_SCREEN)
                    if (editedExit.id.isBlank()) {
                        storageService.save(editedExit)
                    } else {
                        storageService.update(editedExit)
                    }
                } else {
                    SnackbarManager.showMessage(R.string.student_id_length)
                }
            }
        }
    }