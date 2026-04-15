package com.kavkamagdalena.bookshelf.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview


var SampleList : List<MyData> = listOf(
    MyData("903446377", "Before the Coffee Gets Cold", "It tells the story of a café in Tokyo..."),
    MyData("296839472", "Harry Potter and the Philosopher's Stone", "Its story follows Harry's first year at Hogwarts..."),
    MyData("768345324", "The Ballad of Songbirds and Snakes", "A dystopian young adult novel by Suzanne Collins."),
    MyData("112837465", "The Alchemist", "A novel by Paulo Coelho about a young shepherd's journey."),
    MyData("554738291", "1984", "A dystopian novel by George Orwell about a totalitarian society.")
)
@Composable
fun MyItemList(
    onItemClick: (MyData) -> Unit
) {
    var shuffledList by remember { mutableStateOf(SampleList) }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = { shuffledList = shuffledList.shuffled() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xB04F1B2D),
                contentColor = Color.White
            )
        ) {
            Text("Shuffle")
        }

        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(shuffledList) { item ->
                ItemCard(item) { onItemClick(item) }
            }
        }
    }
}