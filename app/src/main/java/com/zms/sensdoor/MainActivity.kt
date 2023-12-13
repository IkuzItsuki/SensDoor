package com.zms.sensdoor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.zms.sensdoor.ui.detail.Detail
import com.zms.sensdoor.ui.home.Home
import com.zms.sensdoor.ui.theme.SensDoorTheme
import com.zms.sensdoor.ui.theme.seed

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            val navController = rememberNavController()
            systemUiController.setStatusBarColor(
                seed.copy(alpha = 0.4f),
                darkIcons = true
            )
            systemUiController.setNavigationBarColor(
                seed.copy(alpha = 0.4f),
                darkIcons = true
            )

            SensDoorTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(seed.copy(alpha = 0.4f))
                ) {
//                    NavHost(navController = navController, startDestination = "home") {
//                        composable("home") {
//                            Home()
//                        }
//                        composable("detail") {
//                            Detail()
//                        }
//                    }
                    Home()
                }
            }
        }
    }
}