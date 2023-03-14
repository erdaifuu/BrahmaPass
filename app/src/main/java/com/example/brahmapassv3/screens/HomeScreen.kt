package com.example.brahmapassv3.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController) {

}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
