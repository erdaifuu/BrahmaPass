package com.example.brahmapassv3.screens.home

import android.view.LayoutInflater
import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
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

@Composable
fun StudentHomeScreen(
    OpenLoginScreen: (String, String) -> Unit,
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: StudentHomeViewModel = hiltViewModel()
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
                    modifier = Modifier.fillMaxWidth())
            },
            backgroundColor = MaterialTheme.colors.primary
        )  },
        content = { padding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize()
            ){
                Text("Home",
                    fontSize = 30.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,)
                Text (displayCurrentTime(),
                    fontSize = 30.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,)
                painterResource(R.drawable.scn_student_home_img_clock_on_student_home)

                BasicButton(R.string.create_hallpass, Modifier.basicButton()) { viewModel.onCreateHallpassClick(openAndPopUp) }
            }
        },
        bottomBar = { BottomBar(OpenLoginScreen) })
}

//FIGURE OUT WTF THIS IS :)
/*
@Composable
fun ReasonDropdown (

)
*/


@Composable
fun BottomBar(
    OpenLoginScreen: (String, String) -> Unit,
) {
    val selectedIndex = remember { mutableStateOf(2) }
    BottomNavigation(elevation = 10.dp) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"")
        },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.ExitToApp,"")
        },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
                OpenLoginScreen(LOGIN_SCREEN, STUDENT_SCREEN)
            })
    }
}

fun displayCurrentTime(): String {
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")
    val formatted = current.format(formatter)
    return "$formatted"
}

fun main(args: Array<String>){
    println(displayCurrentTime())
}
