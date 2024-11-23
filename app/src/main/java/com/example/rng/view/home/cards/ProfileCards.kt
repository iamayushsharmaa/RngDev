package com.example.rng.view.home.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rng.R

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    greeting: String,
    image: Painter,
    name: String,
    onButton1Click: () -> Unit,
    onButton2Click: () -> Unit
) {
    val nameParts = name.split(" ")
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(290.dp)
            .background(color = Color(0xFFf0f0f0))
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(232.dp),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E0E0)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(
                    text = greeting,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }

       
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 28.dp, bottom = 8.dp, top = 16.dp, end = 10.dp)
                .offset(y = 20.dp) // Overlap the bottom of the card
                .fillMaxWidth()
                .height(300.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Card(
                modifier = Modifier
                    .size(width = 130.dp, height = 185.dp),
                shape = RoundedCornerShape(22.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Image(
                    painter = image,
                    contentDescription = "Profile picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 43.dp),
                verticalArrangement = Arrangement.Top
            ) {
                nameParts.forEach { part ->
                    Text(
                        text = part,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(51.dp))

                Row(
                    modifier = Modifier.padding(top = 5.dp, start = 3.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {

                    IconButton(
                        onClick = onButton1Click,
                        modifier = Modifier
                            .size(59.dp)
                            .clip(CircleShape)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.fav),
                            contentDescription = "Icon Button",
                            modifier = Modifier.size(70.dp)
                        )
                    }
                    IconButton(
                        onClick = onButton2Click,
                        modifier = Modifier
                            .size(59.dp)
                            .clip(CircleShape)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.profile_btn),
                            contentDescription = "Icon Button",
                            modifier = Modifier.size(70.dp)
                        )

                    }
                }

            }
        }
    }
}

@Preview
@Composable
private fun OverlappingCard() {
    ProfileCard(
        greeting = "Good Morning",
        image = painterResource(id = R.drawable.profile),
        name = "Sara Anderson",
        onButton1Click = { /* Handle button 1 click */ },
        onButton2Click = { /* Handle button 2 click */ }
        )

}