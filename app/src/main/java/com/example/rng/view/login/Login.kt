package com.example.rng.view.login

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rng.R
import com.example.rng.data.AuthState
import com.example.rng.data.User
import com.example.rng.db.UserDao
import com.example.rng.repo.UserRepository
import com.example.rng.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel
) {
    val authState by loginViewModel.authState.collectAsState()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current
    val activity = context as Activity

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Top,
           horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Image(
                painter = painterResource(id = R.drawable.top_2),
                contentDescription = "login top",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),

                contentScale = ContentScale.Crop // Adjust the scale
            )
            Text(
                text = "UiLover",
                fontSize = 55.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF7F50),
                modifier = Modifier.padding(top = 5.dp, bottom = 13.dp)
            )
            Text(
                text = "Star Your Activity with us",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                modifier = Modifier.padding(13.dp)
            )
            Text(
                text = "Please Login",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(13.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))


            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Enter Your Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Gray,
                    focusedBorderColor = Color.Gray,
                    unfocusedPlaceholderColor = Color.Gray,
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Input Field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Enter Your Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Gray,
                    focusedBorderColor = Color.Gray,
                    unfocusedPlaceholderColor = Color.Gray,

                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Don't Remember Passwor? Recovery it",
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp),
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.width(12.dp)) // Space between divider and text

                Text(
                    text = "Or Login with",
                    color = Color.Black
                )

                Spacer(modifier = Modifier.width(12.dp))


                Divider(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp),
                    color = Color.Gray
                )
            }

            Button(
                onClick = {
                    if (email.isEmpty() || password.isEmpty()) {
                        Toast.makeText(context, "Please fill the details", Toast.LENGTH_SHORT).show()
                    } else {
                        loginViewModel.loginOrRegisterUser(email, password)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(79.dp)
                    .padding(horizontal = 13.dp, vertical = 15.dp)
                ,
                shape = RoundedCornerShape(8.dp),

                colors =  ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF5D3FD3)
                )
            ) {
                Text("Login", fontSize = 25.sp)
            }
            Text(
                text = "Don't have an account?",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )

            Text(
                text = "Signup",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5D3FD3),
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        Toast
                            .makeText(activity, "Enter enter your details", Toast.LENGTH_SHORT)
                            .show()
                    }
            )

            when (authState) {
                is AuthState.Loading -> CircularProgressIndicator(

                )
                is AuthState.Success -> {
                    val succesMessage = (authState as AuthState.Success).message
                    Toast.makeText(activity, succesMessage , Toast.LENGTH_SHORT).show()

                    LaunchedEffect(Unit) {
                        navController.navigate("home") {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                }
                is AuthState.Error -> {
                    Toast.makeText(context, "Something went wrong! Try again", Toast.LENGTH_SHORT).show()
                }

                else -> {}
            }
        }
    }
}


@Preview
@Composable
private fun Login() {
    LoginScreen(rememberNavController(), viewModel())
}