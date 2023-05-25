package com.example.brahmapassv3

import android.content.res.Resources
import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.example.brahmapassv3.common.snackbar.SnackbarManager
import com.example.brahmapassv3.screens.LoginScreen
import com.example.brahmapassv3.screens.confirmation.Confirmation1Screen
import com.example.brahmapassv3.screens.confirmation.Confirmation2Screen
import com.example.brahmapassv3.screens.student_home.StudentHomeScreen
import com.example.brahmapassv3.screens.teacher_home.TeacherHomeScreen
import com.example.brahmapassv3.screens.log.LogScreen
import com.example.brahmapassv3.screens.settings.SettingsScreen
import com.example.brahmapassv3.ui.theme.BrahmapassV3Theme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalAnimationApi::class)
@Composable
@ExperimentalMaterialApi
fun BrahmaPass() {
    BrahmapassV3Theme() {
        Surface(color = MaterialTheme.colors.background) {
            val appState = rememberAppState()

            Scaffold(
                snackbarHost = {
                    SnackbarHost(
                        hostState = it,
                        modifier = Modifier.padding(8.dp),
                        snackbar = { snackbarData ->
                            Snackbar(snackbarData, contentColor = MaterialTheme.colors.onPrimary)
                        }
                    )
                },
                scaffoldState = appState.scaffoldState
            ) { innerPaddingModifier ->
                AnimatedNavHost(
                    navController = appState.navController,
                    startDestination = LOGIN_SCREEN,
                    modifier = Modifier.padding(innerPaddingModifier)
                ) {
                    brahmaPassGraph(appState)
                }
            }
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun rememberAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberAnimatedNavController(),
    snackbarManager: SnackbarManager = SnackbarManager,
    resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) =
    remember(scaffoldState, navController, snackbarManager, resources, coroutineScope) {
        BrahmaPassState(scaffoldState, navController, snackbarManager, resources, coroutineScope)
    }

@Composable
@ReadOnlyComposable
fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}

@OptIn(ExperimentalAnimationApi::class)
@ExperimentalMaterialApi
fun NavGraphBuilder.brahmaPassGraph(appState: BrahmaPassState) {

    composable(
        TEACHER_SCREEN,
        enterTransition = {
            if (initialState.destination.hierarchy.any { it.route == SETTINGS_SCREEN }) {
                slideInHorizontally(initialOffsetX = { 1000 })
            } else
                slideInHorizontally(initialOffsetX = { -1000 })
        },
        exitTransition = {
            if (targetState.destination.hierarchy.any { it.route == LOG_SCREEN }) {
                Log.d("Transition", "LOGSCREEN")
                slideOutHorizontally(targetOffsetX = { -1000 })
            } else if (targetState.destination.hierarchy.any { it.route == SETTINGS_SCREEN }) {
                Log.d("Transition", "SETSCREEN")
                slideOutHorizontally(targetOffsetX = { 1000 })
            }
            else { null }
        }
    ) {
        TeacherHomeScreen(
            OpenSettingsScreen = { route, popUp -> appState.navigateAndPopUp(route, popUp) },
            OpenLogScreen = { route, popUp -> appState.navigateAndPopUp(route, popUp) },
            OpenStudentScreen = { route, popUp -> appState.navigateAndPopUp(route, popUp) }
        )
    }

    composable(
        SETTINGS_SCREEN,
        enterTransition = {
            slideInHorizontally(initialOffsetX = { -1000 })
        },
        exitTransition = { slideOutHorizontally(targetOffsetX = { -1000 }) }
        //exitTransition = { slideOutHorizontally() }
    )
    {
        SettingsScreen(
            OpenTeacherScreen = { route, popUp -> appState.navigateAndPopUp(route, popUp) },
            OpenLogScreen = { route, popUp -> appState.navigateAndPopUp(route, popUp) },
            SignOut = { route, popUp -> appState.navigateAndPopUp(route, popUp) }
        )
    }

    composable(
        LOG_SCREEN,
        enterTransition = {
            slideInHorizontally(initialOffsetX = { 1000 })
        },
        exitTransition = { slideOutHorizontally(targetOffsetX = { 1000 }) }
        //exitTransition = { slideOutHorizontally() }
    )
    {
        LogScreen(
            OpenTeacherScreen = { route, popUp -> appState.navigateAndPopUp(route, popUp) },
            OpenSettingsScreen = { route, popUp -> appState.navigateAndPopUp(route, popUp) },
        )
    }

    composable(LOGIN_SCREEN) {
        LoginScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
    }

    composable(STUDENT_SCREEN) {
        StudentHomeScreen(
            OpenLoginScreen = { route, popUp -> appState.navigateAndPopUp(route, popUp) },
            openAndPopUp =  { route, popUp -> appState.navigateAndPopUp(route, popUp) },
        )
    }

    composable(
        CONFIRMATION1_SCREEN,
        enterTransition = {
            fadeIn(animationSpec = tween(durationMillis = 1000))
        }
    ) {
        Confirmation1Screen(
            OpenConfirmation2Screen = { route, popUp -> appState.navigateAndPopUp(route, popUp) },
        )
    }

    composable(
        CONFIRMATION2_SCREEN,
        enterTransition = {
            fadeIn(animationSpec = tween(durationMillis = 1000))
        }
    ) {
        Confirmation2Screen(
            OpenStudentScreen = { route, popUp -> appState.navigateAndPopUp(route, popUp) },
        )
    }




    /*
    composable(SIGN_UP_SCREEN) {
        SignUpScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
    }

    composable(TASKS_SCREEN) { TasksScreen(openScreen = { route -> appState.navigate(route) }) }

    composable(
        route = "$EDIT_TASK_SCREEN$TASK_ID_ARG",
        arguments = listOf(navArgument(TASK_ID) { defaultValue = TASK_DEFAULT_ID })
    ) {
        EditTaskScreen(
            popUpScreen = { appState.popUp() },
            taskId = it.arguments?.getString(TASK_ID) ?: TASK_DEFAULT_ID
        )
    }
     */
}
