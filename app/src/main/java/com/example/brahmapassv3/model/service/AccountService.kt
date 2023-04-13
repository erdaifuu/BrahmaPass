package com.example.brahmapassv3.model.service

import kotlinx.coroutines.flow.Flow
import com.example.brahmapassv3.model.User

interface AccountService {
    val currentUserId: String
    val hasUser: Boolean

    val currentUser: Flow<User>

    suspend fun authenticate(email: String, password: String)
    suspend fun sendRecoveryEmail(email: String)
    suspend fun createAnonymousAccount()
    suspend fun deleteAccount()
    suspend fun signOut()
}