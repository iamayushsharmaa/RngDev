package com.example.rng.view.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rng.R
import com.example.rng.view.home.cards.CardDiscount
import com.example.rng.view.home.cards.CardWithIcon
import com.example.rng.view.home.cards.ProfileCard
import com.example.rng.viewmodel.LoginViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    loginViewModel: LoginViewModel
) {

    val items = listOf(
        Pair(R.drawable.ic_1, "Inbox"),
        Pair(R.drawable.ic_2, "Maps"),
        Pair(R.drawable.ic_3, "Chat"),
        Pair(R.drawable.ic_4, "Report"),
        Pair(R.drawable.ic_5, "Calander"),
        Pair(R.drawable.ic_6, "Tips"),
        Pair(R.drawable.ic_7, "Settings"),
        Pair(R.drawable.ic_8, "Share"),
        Pair(R.drawable.ic_9, "More")
    )
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFf0f0f0)
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 12.dp)
        ){
            ProfileCard(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp),
                greeting = "Good Morning",
                image =  painterResource(id = R.drawable.profile),
                name = "Sara Anderson",
                onButton1Click = { /* Handle button 1 click */ },
                onButton2Click = { /* Handle button 2 click */ }
            )
            CardDiscount()
            Spacer(Modifier.height(12.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
            ) {
                items(items.size) { index ->
                    val (iconRes, text) = items[index]
                    CardWithIcon(
                        icon = painterResource(id = iconRes),
                        text = text,
                        onClick = { }
                    )
                }
            }
        }
    }

}

@Preview
@Composable
private fun HomeScreenPrev() {

    HomeScreen(navController = rememberNavController(), loginViewModel = viewModel())
}
