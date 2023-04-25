package com.example.brahmapassv3.common.ext

import android.util.Patterns
import java.util.regex.Pattern

private const val MIN_PASS_LENGTH = 6
private const val PASS_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,}$"

fun String.isValidEmail(): Boolean {
    return this.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPassword(): Boolean {
    return this.isNotBlank() &&
            this.length >= MIN_PASS_LENGTH &&
            Pattern.compile(PASS_PATTERN).matcher(this).matches()
}

fun isValidID (id: String): Boolean {
    for (i in 0..id.length)
        for(j in 0..9)
            if(!(id.substring(i..i+1).equals(j)))
                return false
    return true
}

fun String.passwordMatches(repeated: String): Boolean {
    return this == repeated
}

fun String.idFromParameter(): String {
    return this.substring(1, this.length - 1)
}