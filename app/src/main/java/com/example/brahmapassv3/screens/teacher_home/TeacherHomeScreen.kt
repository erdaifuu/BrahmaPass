package com.example.brahmapassv3.screens.teacher_home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.brahmapassv3.*
import com.example.brahmapassv3.R
import com.example.brahmapassv3.common.composable.BasicButton
import com.example.brahmapassv3.common.ext.basicButton
import com.example.brahmapassv3.common.ext.smallSpacer
import com.example.brahmapassv3.model.service.FirstEvent
import com.example.brahmapassv3.model.service.MonthEventList
import com.example.brahmapassv3.screens.log.ExitItem

@Composable
fun TeacherHomeScreen(
    OpenStudentScreen: (String, String) -> Unit,
    OpenSettingsScreen: (String, String) -> Unit,
    OpenLogScreen: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: TeacherHomeViewModel = hiltViewModel()
) {
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        val events = MonthEventList
        val firstEvent = FirstEvent

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
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                ){
                    Row(
                        modifier = Modifier.padding(15.dp)
                    ){
                        Text("Home",
                            fontSize = 30.sp,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,)
                    }

                    //Spacer(modifier = Modifier.smallSpacer())

                    Box(
                        modifier = Modifier
                            .border(BorderStroke(2.dp, Color(R.color.purple_200)), shape = RoundedCornerShape(8.dp))
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontSize = 20.sp)) {
                                    for (i in events.indices) {
                                        if (events[i] == firstEvent) {
                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                append("${events[i]}\n\n")
                                            }
                                        } else if (i == events.lastIndex){
                                            append(events[i])
                                        } else {
                                            append("${events[i]}\n\n")
                                        }
                                    }
                                }
                            },
                            style = TextStyle(fontSize = 16.sp, textAlign = TextAlign.Center),
                            maxLines = 15
                        )
                    }

                    Row(
                        modifier = Modifier
                            .weight(1f, false)
                            .padding(30.dp)
                    ){
                        ToClassModeButton(OpenStudentScreen = OpenStudentScreen)
                    }
                }
                },
            bottomBar = { BottomBar(OpenSettingsScreen, OpenLogScreen) })
}

@Composable
fun ToClassModeButton (
    OpenStudentScreen: (String, String) -> Unit,
) {
    BasicButton (R.string.change_to_class, Modifier.basicButton()){OpenStudentScreen(STUDENT_SCREEN, TEACHER_SCREEN)}
}

@Composable
fun EventDisplay (
    OpenStudentScreen: (String, String) -> Unit,
) {
    BasicButton (R.string.change_to_class, Modifier.basicButton()){OpenStudentScreen(STUDENT_SCREEN, TEACHER_SCREEN)}
}

@Composable
fun BottomBar(
    OpenSettingsScreen: (String, String) -> Unit,
    OpenLogScreen: (String, String) -> Unit,
) {
    val selectedIndex = remember { mutableStateOf(1) }
    BottomNavigation(elevation = 10.dp) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Settings,"")
        },
            selected = (selectedIndex.value == 0),
            onClick = {
                OpenSettingsScreen(SETTINGS_SCREEN, TEACHER_SCREEN)
                selectedIndex.value = 0
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"")
        },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.DateRange,"")
        },
            selected = (selectedIndex.value == 2),
            onClick = {
                OpenLogScreen(LOG_SCREEN, TEACHER_SCREEN)
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
