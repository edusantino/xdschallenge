package com.app.xdschallenge.ui.productlist

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.xdschallenge.R

@Composable
fun TagTextIcon() {
    Row() {
        Icon(
            modifier = Modifier
                .size(24.dp),
            painter = painterResource(R.drawable.fire),
            contentDescription = ""
        )
        Text("230 cals")
    }
}

@Preview
@Composable
fun TagTextIconPreview() {
    TagTextIcon()
}