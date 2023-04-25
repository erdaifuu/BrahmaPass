package com.example.brahmapassv3.screens.confirmation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.brahmapassv3.CONFIRMATION1_SCREEN
import com.example.brahmapassv3.CONFIRMATION2_SCREEN
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds
import android.view.LayoutInflater
import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.brahmapassv3.*
import com.example.brahmapassv3.R
import com.example.brahmapassv3.common.composable.BasicButton
import com.example.brahmapassv3.common.composable.EmailField
import com.example.brahmapassv3.common.composable.IDField
import com.example.brahmapassv3.common.ext.basicButton
import com.example.brahmapassv3.common.ext.fieldModifier
import com.example.brahmapassv3.screens.login.LoginViewModel
import com.example.brahmapassv3.txttime.poppins
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.relay.compose.RelayText
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

@Composable
fun Confirmation2Screen(
    OpenStudentScreen: (String, String) -> Unit
) {
    Column (
        modifier = Modifier.padding(60.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GoToStudentScreen(OpenStudentScreen = OpenStudentScreen)
    }
}

@Composable
fun GoToStudentScreen(
    OpenStudentScreen: (String, String) -> Unit,
) {
    OpenStudentScreen(STUDENT_SCREEN, CONFIRMATION2_SCREEN)
}