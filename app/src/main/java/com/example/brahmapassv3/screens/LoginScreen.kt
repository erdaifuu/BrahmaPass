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
import com.example.brahmapassv3.grppasswordonlogin.BkgBoxOnPasswordOnLogin
import com.example.brahmapassv3.grppasswordonlogin.GrpPasswordOnLogin
import com.example.brahmapassv3.grppasswordonlogin.LblPasswordOnLogin
import com.example.brahmapassv3.grppasswordonlogin.TxtEnterYourPasswordOnLoginInstance
import com.example.brahmapassv3.scnlogin.*
import com.example.brahmapassv3.ui.figma.MyEnterYourPasswordOnLogin
import com.google.relay.compose.BoxScopeInstance.boxAlign
import com.google.relay.compose.BoxScopeInstance.columnWeight
import com.google.relay.compose.BoxScopeInstance.rowWeight


//windowSizeClass: WindowSizeClass
@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()){}
    Column(
        modifier = Modifier.padding(60.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImgBrahmaOnLogin()
        LblBrahmaPassOnLogin()
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
        modifier = Modifier
            .padding(16.dp)
    ) {
        GrpPasswordOnLogin()
    /*
        BkgBoxOnPasswordOnLogin(
            //modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
        )
        LblPasswordOnLogin(
            //modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)
        )
        TxtEnterYourPasswordOnLoginInstance(

        )

         */
    }
}

//TODO: Remember me
@Preview(showBackground = true)
@Composable
fun PasswordTextBoxPreview() {
    PasswordTextBox()
}

@Composable
fun RememberMe() {
    var con = LocalContext.current;
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
    }
}

@Preview(showBackground = true)
@Composable
fun RememberMePreview() {
    RememberMe()
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