package com.example.brahmapassv3.screens

import androidx.annotation.StringRes
import com.example.brahmapassv3.R.string as AppText
import androidx.hilt.navigation.compose.hiltViewModel
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brahmapassv3.common.composable.BasicButton
import com.example.brahmapassv3.common.composable.EmailField
import com.example.brahmapassv3.common.composable.PasswordField
import com.example.brahmapassv3.common.ext.basicButton
import com.example.brahmapassv3.common.ext.fieldModifier
import com.example.brahmapassv3.scnlogin.*
import com.example.brahmapassv3.screens.login.LoginViewModel


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
        EmailField(uiState.email, viewModel::onEmailChange, Modifier.fieldModifier())
        PasswordField(uiState.password, viewModel::onPasswordChange, Modifier.fieldModifier())
        BasicButton(AppText.sign_in, Modifier.basicButton()) { viewModel.onSignInClick(openAndPopUp) }
    }
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