package com.example.brahmapassv3.screens

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.StringRes
import com.example.brahmapassv3.R.string as AppText
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.brahmapassv3.grppasswordonlogin.GrpPasswordOnLogin
import com.example.brahmapassv3.grppasswordonlogin.LblPasswordOnLogin
import com.example.brahmapassv3.grppasswordonlogin.TxtEnterYourPasswordOnLoginInstance
import com.example.brahmapassv3.model.service.impl.AccountServiceImpl
import com.example.brahmapassv3.scnlogin.*
import com.example.brahmapassv3.screens.login.LoginViewModel
import com.example.brahmapassv3.ui.figma.MyEnterYourPasswordOnLogin
import com.google.relay.compose.BoxScopeInstance.boxAlign
import com.google.relay.compose.BoxScopeInstance.columnWeight
import com.google.relay.compose.BoxScopeInstance.rowWeight
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase




//windowSizeClass: WindowSizeClass
@Composable
fun LoginScreen(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
    ) {

    val uiState by viewModel.uiState

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
            modifier = Modifier.padding(8.dp)
        )

        GrpPasswordOnLoginInstance(
            modifier = Modifier.padding(8.dp)
        )

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*
        BtnLoginButtonOnLoginInstance(
            modifier = Modifier
                .padding(60.dp)
                .clickable(onClick = {  })
        )
         */
        BasicButton(AppText.sign_in, modifier = Modifier) { viewModel.onSignInClick() }
    }
}

@Composable
fun BasicButton(@StringRes text: Int, modifier: Modifier, action: () -> Unit) {
    Button(
        onClick = action,
        modifier = modifier,
        colors =
        ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary
        )
    ) {
        Text(text = stringResource(text), fontSize = 16.sp)
    }
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