package com.example.brahmapassv3.screens

import android.view.LayoutInflater
import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.brahmapassv3.txttime.poppins
import com.google.relay.compose.RelayText
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun StudentHomeScreen(navController: NavController) {

}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun StudentHomeScreenPreview() {
    StudentHomeScreen(navController = rememberNavController())
    TxtTimeOnStudentHome()
}

@Composable
fun TxtTimeOnStudentHome(modifier: Modifier = Modifier) {
    RelayText(
        content = displayCurrentTime(),
        fontSize = 28.0.sp,
        fontFamily = poppins,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.5.em,
        fontWeight = FontWeight(300.0.toInt()),
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

fun displayCurrentTime(): String {
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")
    val formatted = current.format(formatter)
    return "$formatted"
}

fun main(args: Array<String>){
    println(displayCurrentTime())
}
