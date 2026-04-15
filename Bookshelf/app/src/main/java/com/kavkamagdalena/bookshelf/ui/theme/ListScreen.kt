package com.kavkamagdalena.bookshelf.ui.theme

import androidx.compose.runtime.Composable


@Composable
fun ListScreen(onItemClick: (MyData) -> Unit) {
    MyItemList(onItemClick = onItemClick)
}