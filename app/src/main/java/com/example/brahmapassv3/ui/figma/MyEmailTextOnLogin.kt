package com.example.brahmapassv3.ui.figma

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.brahmapassv3.grpemailonlogin.*
import com.google.relay.compose.RelayText

@Composable
fun MyEmailTextOnLogin(
    modifier: Modifier = Modifier,
    textInputForPassword: String = "Hi"
) {
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

@Preview(widthDp = 374, heightDp = 79)
@Composable
fun MyEmailTextOnLoginPreview() {
    MyEmailTextOnLogin()
}