/*
Copyright 2022 Google LLC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.example.brahmapassv3.screens.log

import androidx.compose.runtime.mutableStateOf
import com.example.brahmapassv3.model.Exit
import com.example.brahmapassv3.model.service.ConfigurationService
import com.example.brahmapassv3.model.service.LogService
import com.example.brahmapassv3.model.service.StorageService
import com.example.brahmapassv3.screens.MakeItSoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogViewModel @Inject constructor(
    logService: LogService,
    private val storageService: StorageService,
    private val configurationService: ConfigurationService
) : MakeItSoViewModel(logService) {
    val options = mutableStateOf<List<String>>(listOf())

    val exits = storageService.exits

    fun loadExitOptions() {
        val hasEditOption = configurationService.isShowExitEditButtonConfig
        options.value = ExitActionOption.getOptions(hasEditOption)
    }


    fun onExitCheckChange(exit: Exit) {
        launchCatching { storageService.update(exit.copy()) }
    }

    /*
    fun onAddClick(openScreen: (String) -> Unit) = openScreen(EDIT_TASK_SCREEN)

    fun onSettingsClick(openScreen: (String) -> Unit) = openScreen(SETTINGS_SCREEN)


    fun onExitActionClick(openScreen: (String) -> Unit, exit: Exit, action: String) {
        when (ExitActionOption.getByTitle(action)) {
            ExitActionOption.EditExit -> openScreen("$EDIT_TASK_SCREEN?$TASK_ID={${exit.id}}")
            ExitActionOption.ToggleFlag -> onFlagExitClick(exit)
            ExitActionOption.DeleteExit -> onDeleteExitClick(exit)
        }
    }

     */

    /*
    private fun onFlagExitClick(exit: Exit) {
        launchCatching { storageService.update(exit.copy(flag = !exit.flag)) }
    }

     */

    private fun onDeleteExitClick(exit: Exit) {
        launchCatching { storageService.delete(exit.id) }
    }
}