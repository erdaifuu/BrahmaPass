package com.example.brahmapassv3

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.brahmapassv3.scnhome.ScnHome
import com.example.brahmapassv3.scnlogin.ScnLogin

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login")
    object HomeScreen : Screen("home")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}