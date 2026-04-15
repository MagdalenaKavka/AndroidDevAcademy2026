package com.kavkamagdalena.bookshelf.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage


@Preview(showBackground = true)
@Composable
fun ItemCard(
    myData: MyData = MyData("123456789", "Seven Husbands Of Evelyn Hugo", "“Doesn’t it bother you? That all anyone talks about when they talk about you are the seven husbands of Evelyn Hugo?” "),
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .padding(30.dp)
            .wrapContentHeight()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                AsyncImage(
                    model = "https://m.media-amazon.com/images/S/compressed.photo.goodreads.com/books/1664458703i/32620332.jpg",
                    contentDescription = "" ,
                    modifier = Modifier.size(80.dp)

                )
                TitleText(text = myData.title)
            }

            DescriptionText(text = myData.description)

            Row() {
                CustomButton(text = "Favourite")
                Spacer(modifier = Modifier.width(10.dp))
                CustomButton(text = "Mark as read")
            }
        }


    }
}


