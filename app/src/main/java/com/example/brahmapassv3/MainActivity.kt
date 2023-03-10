/*package com.example.brahmapassv3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.brahmapassv3.scnhome.ScnHome
import com.example.brahmapassv3.scnlogin.ScnLogin
import com.example.brahmapassv3.ui.theme.BrahmapassV3Theme
import androidx.window.*
import java.util.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrahmapassV3Theme {
                //val WindowSizeClass = calculateWindowSizeClass(this)
            }
        }
       // computeWindowSizeClasses()
    }
    /*private fun computeWindowSizeClasses() {
        val metrics = WindowMetricsCalculator.getOrCreate()
            .computeCurrentWindowMetrics(this)
        val widthDp = metrics.bounds.width() /
                resources.displayMetrics.density
        val widthWindowSizeClass = when {
            widthDp < 600f -> WindowSizeClass.COMPACT
            widthDp < 840f -> WindowSizeClass.MEDIUM
            else -> WindowSizeClass.EXPANDED
        }
        val heightDp = metrics.bounds.height() /
                resources.displayMetrics.density
        val heightWindowSizeClass = when {
            heightDp < 480f -> WindowSizeClass.COMPACT
            heightDp < 900f -> WindowSizeClass.MEDIUM
            else -> WindowSizeClass.EXPANDED
        }
    }*/
    }


    @Composable
    fun HomeScreen(name: String) {
        //val navController = rememberNavController()
        ScnHome(
            txtEnterIDOnHomeTextContent = "Enter ID... ",
            txtEnterReasonOnHomeTextContent = "Enter here... "
        )
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance(TimeZone.getTimeZone("PST")).time
    }

*/