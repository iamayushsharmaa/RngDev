package com.example.rng.view.home.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rng.R
@Composable
fun CardDiscount() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(5.dp)
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFDDA0D)
        ),
        shape = RoundedCornerShape(19.dp),
        onClick = {}
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFFFBF00))
        ) {
            // First column
            Column(
                modifier = Modifier
                    .weight(1f) // Takes only necessary space for its content
                    .fillMaxHeight()
                    .padding(5.dp)
            ) {
                Text(
                    text = "until 20 june-30 june",
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 7.dp, vertical = 8.dp)
                )
                Text(
                    text = "30%",
                    fontSize = 45.sp,
                    color = Color(0xFF5D3FD3),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 7.dp, vertical = 5.dp)
                )
                Text(
                    text = "Discount",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 7.dp, vertical = 8.dp)
                )
            }

            Spacer(Modifier.width(20.dp))

            Column(
                modifier = Modifier
                    .weight(1f) // Expands to fill the remaining space
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_banner),
                    contentDescription = "icon in card",
                    modifier = Modifier
                        .size(200.dp)
                        .aspectRatio(1f)
                        .padding(start = 25.dp) // Optional padding on the right
                )
            }
        }
    }
}

@Preview
@Composable
private fun Cards() {
    CardDiscount()
}