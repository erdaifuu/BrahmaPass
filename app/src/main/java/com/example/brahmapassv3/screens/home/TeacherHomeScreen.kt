package com.example.brahmapassv3.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.brahmapassv3.*
import com.example.brahmapassv3.R
import com.example.brahmapassv3.common.composable.BasicButton
import com.example.brahmapassv3.common.ext.basicButton
import com.example.brahmapassv3.screens.login.LoginViewModel
import com.example.brahmapassv3.txttime.poppins

@Composable
fun TeacherHomeScreen(
    OpenStudentScreen: (String, String) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(15.dp).fillMaxSize()
    ){
        Text("Home",
            fontSize = 30.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,)
        ToClassModeButton(OpenStudentScreen = OpenStudentScreen)
    }

}

@Composable
fun ToClassModeButton (
    OpenStudentScreen: (String, String) -> Unit,
) {
    BasicButton (R.string.change_to_class, Modifier.basicButton()){OpenStudentScreen(STUDENT_SCREEN, TEACHER_SCREEN)}
}

val poppinsFamily: FontFamily = FontFamily(
    Font(R.font.relay_poppins_black, FontWeight.Light),
    Font(R.font.relay_poppins_regular, FontWeight.Normal),
    Font(R.font.relay_poppins_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.relay_poppins_medium, FontWeight.Medium),
    Font(R.font.relay_poppins_bold, FontWeight.Bold)
)
