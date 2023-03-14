package com.example.brahmapassv3.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.brahmapassv3.scnlogin.*
import com.google.relay.compose.BoxScopeInstance.boxAlign
import com.google.relay.compose.BoxScopeInstance.columnWeight
import com.google.relay.compose.BoxScopeInstance.rowWeight

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()){

    }
    BtnLoginButtonOnLoginInstance(
        modifier = Modifier.boxAlign(
            alignment = Alignment.TopStart,
            offset = DpOffset(
                x = 0.dp,
                y = 536.0.dp
            )
        )
    )
    GrpCheckboxVariantsOnLogin(
        modifier = Modifier.boxAlign(
            alignment = Alignment.TopStart,
            offset = DpOffset(
                x = 0.dp,
                y = 449.0.dp
            )
        )
    )
    LblRememberMeOnLogin(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
    GrpPasswordOnLoginInstance(
        modifier = Modifier.boxAlign(
            alignment = Alignment.TopStart,
            offset = DpOffset(
                x = 0.dp,
                y = 347.0.dp
            )
        )
    )
    GrpEyeconVariantsInstance(
        modifier = Modifier.boxAlign(
            alignment = Alignment.TopStart,
            offset = DpOffset(
                x = 0.dp,
                y = 390.0.dp
            )
        )
    )
    GrpEmailOnLoginInstance(
        modifier = Modifier.boxAlign(
            alignment = Alignment.TopStart,
            offset = DpOffset(
                x = 0.dp,
                y = 244.0.dp
            )
        )
    )
    ImgBrahmaOnLogin(
        modifier = Modifier.boxAlign(
            alignment = Alignment.TopStart,
            offset = DpOffset(
                x = 0.dp,
                y = 125.0.dp
            )
        )
    )
    LblBrahmaPassOnLogin(
        modifier = Modifier.boxAlign(
            alignment = Alignment.TopCenter,
            offset = DpOffset(
                x = 0.0.dp,
                y = 72.0.dp
            )
        )
    )
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}

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