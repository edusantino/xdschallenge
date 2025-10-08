package com.santino.presentation.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.xdschallenge.R

@Composable
fun ItemCard() {
    Card() {
        Row {
            TagTextIcon()
            //TagSave()
        }
        Image(modifier = Modifier
            .size(width = 80.dp, height = 120.dp),
            painter = painterResource(R.drawable.ic_search),
            contentDescription = ""
        )
    }
}

@Preview
@Composable
fun ItemCardPreview() {
    ItemCard()
}