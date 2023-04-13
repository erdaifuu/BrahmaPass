package com.example.brahmapassv3.screens.log

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.brahmapassv3.screens.login.LoginViewModel
import com.example.brahmapassv3.txttime.poppins

@Composable
fun LogScreen(
    OpenTeacherScreen: (String, String) -> Unit,
    OpenSettingsScreen: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { TopAppBar(
                title = {
                    Text(text = "BrahmaPass",
                        fontSize = 30.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth())},
                backgroundColor = MaterialTheme.colors.primary
            )  },
            content = { padding ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxSize()
                ){
                    Text("Exit Log",
                        fontSize = 30.sp,
                        fontFamily = com.example.brahmapassv3.screens.home.poppinsFamily,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,) }
                },
            bottomBar = { BottomBar(OpenTeacherScreen, OpenSettingsScreen) })
}

@Composable
fun BottomBar(
    OpenTeacherScreen: (String, String) -> Unit,
    OpenSettingsScreen: (String, String) -> Unit,
) {
    val selectedIndex = remember { mutableStateOf(2) }
    BottomNavigation(elevation = 10.dp) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Settings,"")
        },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
                OpenTeacherScreen(SETTINGS_SCREEN, LOG_SCREEN)
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"")
        },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
                OpenSettingsScreen(TEACHER_SCREEN, LOG_SCREEN)
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.DateRange,"")
        },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            })
    }
}


val poppinsFamily: FontFamily = FontFamily(
    Font(R.font.relay_poppins_black, FontWeight.Light),
    Font(R.font.relay_poppins_regular, FontWeight.Normal),
    Font(R.font.relay_poppins_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.relay_poppins_medium, FontWeight.Medium),
    Font(R.font.relay_poppins_bold, FontWeight.Bold)
)
