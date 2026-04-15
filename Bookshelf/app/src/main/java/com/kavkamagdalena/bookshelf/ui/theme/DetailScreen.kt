package com.kavkamagdalena.bookshelf.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun DetailScreen(ID: String?, onBackClick: () -> Unit) {
    val item = SampleList.find {it.ID == ID}

    Column(modifier = Modifier.fillMaxSize()) {
        Text(item?.title ?: "")
        Text(item?.description ?: "")

        Button(onClick = onBackClick) {
            Text("Back")
        }

    }

}