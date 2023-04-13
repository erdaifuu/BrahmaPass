package com.example.brahmapassv3.model.service

interface LogService {
    fun logNonFatalCrash(throwable: Throwable)
}