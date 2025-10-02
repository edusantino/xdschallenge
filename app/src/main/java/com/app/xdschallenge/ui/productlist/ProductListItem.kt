package com.app.xdschallenge.ui.productlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.xdschallenge.R

@Composable
fun ProductListItem() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(containerColor = Color(40, 44, 48))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .size(width = 190.dp, height = 130.dp),
                painter = painterResource(R.drawable.mini),
                contentDescription = "Pizza de Peperoni"
            )
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .padding(horizontal = 10.dp),
                    text = "Pizza de Peperoni",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 22.sp
                )
                Text(
                    modifier = Modifier
                        .padding(top = 5.dp, start = 10.dp),
                    text = "a partir de:",
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontSize = 13.sp
                )
                Text(
                    modifier = Modifier
                        .padding(top = 5.dp, start = 10.dp),
                    text = "R$ 29,90",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 18.sp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Slider(
                        modifier = Modifier
                            .size(height = 20.dp, width = 100.dp),
                        value = sliderPosition,
                        onValueChange = { sliderPosition = it }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductListItemPreview() {
    ProductListItem()
}