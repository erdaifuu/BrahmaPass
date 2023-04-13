package com.example.brahmapassv3

import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.brahmapassv3.screens.LoginScreen
//import com.example.brahmapassv3.scnlogin.ScnLogin
import com.example.brahmapassv3.ui.theme.BrahmapassV3Theme
import dagger.hilt.android.AndroidEntryPoint
import com.example.brahmapassv3.EventScraper
import com.example.brahmapassv3.model.service.EventScraperService
import dagger.hilt.android.HiltAndroidApp
@AndroidEntryPoint
@ExperimentalMaterialApi
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val color = ContextCompat.getColor(this, R.color.purple_200)
        window.statusBarColor = color // Set color of system statusBar same as ActionBar
        window.navigationBarColor = color // Set color of system navigationBar same as BottomNavigationView
        Log.d("EventScraper","I am here");
        EventScraperService()

        setContent { BrahmaPass() }
    }
}