package com.example.rng

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rng.splash.SplashScreen
import com.example.rng.ui.theme.RNGTheme
import com.example.rng.view.home.HomeScreen
import com.example.rng.view.login.LoginScreen
import com.example.rng.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RNGTheme {
                val roomViewmodel : LoginViewModel by viewModels()
                val navController = rememberNavController()
                NavHost(navController = navController , startDestination = "splash"){
                    composable("splash") {
                        SplashScreen(
                            navController,
                            roomViewmodel
                        )
                    }
                    composable("login") {
                        LoginScreen(
                            navController,
                            roomViewmodel
                        )
                    }
                    composable("home") {
                        HomeScreen(
                            navController,
                            roomViewmodel
                        )
                    }
                }
            }
        }
    }
}

