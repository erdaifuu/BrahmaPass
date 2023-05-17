package com.example.brahmapassv3.screens.teacher_home


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