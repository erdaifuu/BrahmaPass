package com.example.brahmapassv3

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.brahmapassv3.scnhome.ScnHome
//import com.example.brahmapassv3.scnlogin.ScnLogin

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
            HomeScreen(name = entry.arguments?.getString("name"), navController = navController)
        }
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    /*
    ScnLogin(
        //onGrpLoginButtonOnLoginTapped = {navController.navigate("second/$text") },
        //TODO: figure out what the fuck this is
        onGrpLoginButtonOnLoginTapped = {
            Toast.makeText(context, "Welcome in!", Toast.LENGTH_LONG).show()
            // You can also do Screen.HomeScreen.route, but with withArgs() defined in the screens
            // class, you could pass args THROUGH the routes like the name in this case which
            // can be picked up by home screen and used as shown below.
            navController.navigate(Screen.HomeScreen.route)
            // You can just pass the TEXT BOX CONTENT into the args, or just a default string.
        },
        txtEmailExampleOnEmailTextContent = "hello",
        txtEnterYourPasswordOnLoginTextContent = "world")
*/
}

@Composable
fun HomeScreen(name: String?, navController: NavController) {
    /*
    ScnHome(
        txtEnterIDOnHomeTextContent = "Hi, $name!",
        txtEnterReasonOnHomeTextContent = "What's up")

     */
}


