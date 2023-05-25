package com.example.brahmapassv3.screens.student_home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.brahmapassv3.*
import com.example.brahmapassv3.R
import com.example.brahmapassv3.common.composable.BasicButton
import com.example.brahmapassv3.common.composable.IDField
import com.example.brahmapassv3.common.ext.basicButton
import com.example.brahmapassv3.common.ext.fieldModifier
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.example.brahmapassv3.screens.teacher_home.poppinsFamily
import kotlinx.coroutines.delay

@Composable
fun StudentHomeScreen(
    OpenLoginScreen: (String, String) -> Unit,
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: StudentHomeViewModel = hiltViewModel(),
) {
    val exit by viewModel.exit
    val con = LocalContext.current;

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
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(15.dp)
                        .weight(2f, false)
                ) {
                    Text("Home",
                        fontSize = 30.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,)
                    TimeDisplay()
                    Image(painter = painterResource(R.drawable.scn_student_home_img_clock_on_student_home), contentDescription = "Clock")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(15.dp)
                ) {
                    //StudentIdField(value = exit.studentId.toString(), onChange = viewModel::onIdChange)
                    IDField(idState = IdTextFieldState(), onNewValue = viewModel::onIdChange, Modifier.fieldModifier())
                    ReasonDropdown(Modifier.fieldModifier(), viewModel::onReasonChange)
                }
                Row(
                    modifier = Modifier
                        .weight(1f, false)
                        .padding(30.dp)
                ){
                    BasicButton(R.string.create_hallpass, Modifier.basicButton()) { viewModel.onCreateHallPassClick(con, openAndPopUp) }
                }
            }
        },
        bottomBar = { BottomBar(OpenLoginScreen) })
}

@Composable
fun TimeDisplay() {
    var timeText by remember { mutableStateOf(displayCurrentTime()) }

    Text (timeText,
        fontSize = 30.sp,
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Center,)

    LaunchedEffect(Unit) {
        while (true) {
            timeText = displayCurrentTime()
            delay(1000)
        }
    }
}

class IdTextFieldState(){
    var idText: String by mutableStateOf("")
}


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
                OpenLoginScreen(TEACHER_SCREEN, STUDENT_SCREEN)
            })
    }
}



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReasonDropdown(
    modifier: Modifier,
    onNewValue: (String) -> Unit
) {
    val listItems = arrayOf("Bathroom", "GLC", "Office", "Nurse", "Other")
    val contextForToast = LocalContext.current.applicationContext

    // state of the menu
    var expanded by remember {
        mutableStateOf(false)
    }

    // remember the selected item
    var selectedItem by remember {
        mutableStateOf(listItems[0])
    }

    // box
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        OutlinedTextField(
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = "Enter Reason") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            listItems.forEach { selectedOption ->
                DropdownMenuItem(onClick = {
                    selectedItem = selectedOption
                    //Toast.makeText(contextForToast, selectedOption, Toast.LENGTH_SHORT).show()
                    onNewValue(selectedOption)
                    expanded = false
                }) {
                    Text(text = selectedOption)
                }
            }
        }
    }
}

fun displayCurrentTime(): String {
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")
    return current.format(formatter)
}

fun main(args: Array<String>){
    println(displayCurrentTime())
}
