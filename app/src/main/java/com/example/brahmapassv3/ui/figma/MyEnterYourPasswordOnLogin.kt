package com.example.brahmapassv3.ui.figma

import androidx.compose.material.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.brahmapassv3.txtenteryourpasswordonlogin.TopLevel
import com.example.brahmapassv3.txtenteryourpasswordonlogin.TxtEnterYourPasswordOnLogin

@Composable
fun MyEnterYourPasswordOnLogin(
    modifier: Modifier = Modifier,
    enterPasswordInputOnLogin: String
) {

    TopLevel(modifier = modifier) {
        var value by remember {
            mutableStateOf("")
        }


        TextField(
            value = value,
            onValueChange = { newText ->
                value = newText
            }
        )
    }

}

@Preview(widthDp = 374, heightDp = 79)
@Composable
fun MyEnterYourPasswordOnLoginPreview() {
    MyEnterYourPasswordOnLogin(modifier = Modifier, "hello")
}