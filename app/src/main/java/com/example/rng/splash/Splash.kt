package com.example.rng.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rng.R
import com.example.rng.viewmodel.LoginViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController, roomViewmodel: LoginViewModel, ) {

    LaunchedEffect(Unit) {
        val isLoggedIn = roomViewmodel.isUserLoggedIn()
        delay(2000)
        if (isLoggedIn) {
            navController.navigate("home") {
                popUpTo("splash") { inclusive = true }
            }
        } else {
            navController.navigate("login") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFF5F1F)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Image
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(208.dp),
            painter = painterResource(id = R.drawable.top_1),
            contentDescription = "icon top"
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 16.dp) // Optional padding
        ) {
            Text(
                text = "UiLover",
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                text = "A vision for the future with our channel",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(208.dp),
            painter = painterResource(id = R.drawable.bottom_1),
            contentDescription = "icon bottom"
        )
    }

}

@Preview
@Composable
private fun SplashView() {

    SplashScreen(navController = rememberNavController(), roomViewmodel = viewModel())
}
