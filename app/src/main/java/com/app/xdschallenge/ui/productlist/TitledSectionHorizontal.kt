package com.app.xdschallenge.ui.productlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TitledSectionHorizontal() {
    Column {
        Text(text = "Title", modifier = Modifier.fillMaxWidth())
        LazyRow {

        }
    }
}

@Preview
@Composable
fun TitledSectionPreview() {
    TitledSectionHorizontal()
}