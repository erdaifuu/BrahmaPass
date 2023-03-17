package com.example.brahmapassv3.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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


//windowSizeClass: WindowSizeClass
@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()){

    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GrpEmailOnLoginInstance(
            modifier = Modifier.padding(16.dp)
        )

        PasswordTextBox()

        BtnLoginButtonOnLoginInstance(
            modifier = Modifier.padding(16.dp)
        )
    }

    Row(
        verticalAlignment = Alignment.Top
    ) {
        LblRememberMeOnLogin(

        )

        GrpCheckboxVariantsOnLogin(
            modifier = Modifier.padding(16.dp)
        )
    }

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

@Composable
fun PasswordTextBox() {
    var con = LocalContext.current;
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        GrpPasswordOnLoginInstance()
        TxtEnterYourPasswordOnLoginInstance(
            modifier = Modifier
                .offset(y = 40.dp)
        )
        GrpEyeconVariantsInstance(
            modifier = Modifier
                .offset(x = 340.dp, y = 42.dp)
                .size(10.dp)
                .clickable(onClick = {Toast.makeText(con, "Hello", Toast.LENGTH_SHORT).show()})
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PasswordTextBoxPreview() {
    PasswordTextBox()
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