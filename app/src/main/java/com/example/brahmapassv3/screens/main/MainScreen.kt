package com.example.brahmapassv3.screens.main

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
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.relay.compose.RelayText
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.brahmapassv3.common.composable.BasicField
import com.example.brahmapassv3.common.ext.smallSpacer
import com.example.brahmapassv3.screens.home.BottomBar
import com.example.brahmapassv3.screens.home.ReasonDropdown
import com.example.brahmapassv3.screens.home.ToClassModeButton
import com.example.brahmapassv3.screens.home.displayCurrentTime
import com.example.brahmapassv3.screens.home.poppinsFamily
import com.example.brahmapassv3.screens.log.ExitItem
import com.example.brahmapassv3.screens.log.LogViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen (
    OpenStudentScreen: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LogViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val selectedIndex = remember { mutableStateOf(1) }
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
            if (selectedIndex.value == 0) {
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
                    ToClassModeButton(OpenStudentScreen = OpenStudentScreen)
                }
            }
            else if (selectedIndex.value == 1) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxSize()
                ){
                    Text("Settings",
                        fontSize = 30.sp,
                        fontFamily = com.example.brahmapassv3.screens.home.poppinsFamily,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,) }
            }
            else if (selectedIndex.value == 2) {
                val exits = viewModel.exits.collectAsStateWithLifecycle(emptyList())
                val options by viewModel.options

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
                        textAlign = TextAlign.Center,)

                    Spacer(modifier = Modifier.smallSpacer())

                    LazyColumn {
                        items(exits.value, key = { it.id }) { exitItem ->
                            ExitItem(
                                exit = exitItem,
                                options = options,
                            )
                        }
                    }
                }
            }

        },
        bottomBar = { BottomBar() })
}

/*
Teacher Screen: selectedIndex = 0
Settings Screen: selectedIndex = 1
Log Screen: selectedIndex = 2
 */

@Composable
fun BottomBar(
) {
    val selectedIndex = remember { mutableStateOf(0) }
    val visible = remember { mutableStateOf(true) }

    BottomNavigation(elevation = 10.dp) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"")
        },
            selected = (selectedIndex.value == 0),
            onClick = {
                fadeOut()
                selectedIndex.value = 0
                fadeIn()
            })


        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Settings,"")
        },
            selected = (selectedIndex.value == 1),
            onClick = {
                fadeOut()
                selectedIndex.value = 1
                fadeIn()
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.DateRange,"")
        },
            selected = (selectedIndex.value == 2),
            onClick = {
                fadeOut()
                selectedIndex.value = 2
                fadeIn()
            })
    }
}
