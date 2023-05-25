package com.example.brahmapassv3

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.core.content.ContextCompat
//import com.example.brahmapassv3.scnlogin.ScnLogin
import dagger.hilt.android.AndroidEntryPoint
import com.example.brahmapassv3.model.service.eventScraperService

@AndroidEntryPoint
@ExperimentalMaterialApi
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val color = ContextCompat.getColor(this, R.color.purple_200)
        window.statusBarColor = color // Set color of system statusBar same as ActionBar
        window.navigationBarColor = color // Set color of system navigationBar same as BottomNavigationView
        Log.d("EventScraper","I am online.");
        eventScraperService()

        setContent { BrahmaPass() }
    }
}