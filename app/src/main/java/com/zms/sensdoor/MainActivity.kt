package com.zms.sensdoor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.zms.sensdoor.ui.detail.Detail
import com.zms.sensdoor.ui.home.Home
import com.zms.sensdoor.ui.setup.Setup
import com.zms.sensdoor.ui.theme.SensDoorTheme
import com.zms.sensdoor.ui.theme.seed
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
                    NavHost(navController = navController, startDestination = "setup") {
                        composable("setup") {
                            Setup(
                                navController
                            )
                        }
                        composable("home") {
                            Home(
                                navController
                            )
                        }
                        composable("detail") {
                            Detail(
                                navController
                            )
                        }
                    }
                }
            }
        }
    }
}