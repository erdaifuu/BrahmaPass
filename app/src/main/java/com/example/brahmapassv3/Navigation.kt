package com.example.brahmapassv3

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.brahmapassv3.scnlogin.BtnLoginButtonOnLoginInstance
import com.example.brahmapassv3.screens.HomeScreen
import com.example.brahmapassv3.screens.LoginScreen
import com.google.relay.compose.BoxScopeInstance.boxAlign

//https://www.youtube.com/watch?v=4gUeyNkGE3g
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(
            // Basically testing passing through values THROUGH the routes
            route = Screen.HomeScreen.route,
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Carl"
                    nullable = true
                }
            )
        ) { entry ->
            HomeScreen(navController = navController)
            //name = entry.arguments?.getString("name"),
        }
    }
}


