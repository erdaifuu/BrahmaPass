package com.example.brahmapassv3.screens.settings

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.graphics.Shape
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

@Composable
fun SettingsScreen(
    OpenTeacherScreen: (String, String) -> Unit,
    OpenLogScreen: (String, String) -> Unit,
    SignOut: (String, String) -> Unit,
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
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                ){
                    Column(
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Text(
                            "Settings",
                            fontSize = 30.sp,
                            fontFamily = com.example.brahmapassv3.screens.teacher_home.poppinsFamily,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                        )
                    }
                    Row(
                        modifier = Modifier
                            .weight(1f, false)
                            .padding(30.dp)
                            .fillMaxWidth(),
                    ) {
                        TiledButton(
                            onClick = { viewModel.onSignOutClick(SignOut) },
                            border = BorderStroke(1.dp, Color(0xFF8B54F7)),
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Icon(Icons.Default.ExitToApp, "")
                            Text("Sign out")
                        }
                    }
                }
            },
            bottomBar = { BottomBar(OpenTeacherScreen, OpenLogScreen) })
}

@Composable
fun BottomBar(
    OpenTeacherScreen: (String, String) -> Unit,
    OpenLogScreen: (String, String) -> Unit
) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(elevation = 10.dp) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Settings,"")
        },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"")
        },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
                OpenTeacherScreen(TEACHER_SCREEN, SETTINGS_SCREEN)
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.DateRange,"")
        },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
                OpenLogScreen(LOG_SCREEN, SETTINGS_SCREEN)
            })
    }
}

@Composable
fun TiledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    contentColor: Color = MaterialTheme.colors.primary,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(0.dp),
        enabled = enabled,
        shape = shape,
        border = border,
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = contentColor,
            disabledBackgroundColor = Color.Transparent,
            disabledContentColor = contentColor.copy(alpha = ContentAlpha.disabled),
        ),
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(contentPadding),
                content = content,
            )
        }
    }
}

val poppinsFamily: FontFamily = FontFamily(
    Font(R.font.relay_poppins_black, FontWeight.Light),
    Font(R.font.relay_poppins_regular, FontWeight.Normal),
    Font(R.font.relay_poppins_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.relay_poppins_medium, FontWeight.Medium),
    Font(R.font.relay_poppins_bold, FontWeight.Bold)
)
