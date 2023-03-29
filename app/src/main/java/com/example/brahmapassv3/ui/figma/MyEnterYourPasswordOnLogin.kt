package com.example.brahmapassv3.ui.figma

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.brahmapassv3.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.brahmapassv3.txtenteryourpasswordonlogin.TopLevel
import com.example.brahmapassv3.txtenteryourpasswordonlogin.TxtEnterYourPasswordOnLogin

public var inputPassword = ""

@Composable
fun MyEnterYourPasswordOnLogin(
    modifier: Modifier = Modifier,
    enterPasswordInputOnLogin: String = "Hello"
) {
    TopLevel(modifier = modifier) {
        var password by remember {
            mutableStateOf("")
        }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it;
                inputPassword = password},
            singleLine = true,
            placeholder = { Text("Enter Your Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible)
                    ImageVector.vectorResource(id = R.drawable.baseline_visibility_24)
                else ImageVector.vectorResource(id = R.drawable.baseline_visibility_off_24)

                // Please provide localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Icon(imageVector  = image, description)
                }
            }
        )
    }

}

@Preview(widthDp = 374, heightDp = 79)
@Composable
fun MyEnterYourPasswordOnLoginPreview() {
    MyEnterYourPasswordOnLogin(modifier = Modifier, "hello")
}