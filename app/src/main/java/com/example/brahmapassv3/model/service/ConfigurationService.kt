package com.example.brahmapassv3.model.service

interface ConfigurationService {
    suspend fun fetchConfiguration(): Boolean
    val isShowExitEditButtonConfig: Boolean
}
