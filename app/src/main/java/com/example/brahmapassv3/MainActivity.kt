package com.example.brahmapassv3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.*
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.rememberNavController
import com.example.brahmapassv3.scnlogin.GrpLoginButtonOnLogin
import com.example.brahmapassv3.scnlogin.ScnLogin
import com.example.brahmapassv3.ui.theme.BrahmapassV3Theme
import androidx.navigation.compose.composable
import com.example.brahmapassv3.scnhome.ScnHome

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrahmapassV3Theme {
                Navigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BrahmapassV3Theme {

    }
}