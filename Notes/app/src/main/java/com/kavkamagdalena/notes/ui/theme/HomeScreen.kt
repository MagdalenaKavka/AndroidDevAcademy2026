package com.kavkamagdalena.notes.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    onItemClick: (Note) -> Unit,
    onAddClick: () -> Unit,
    viewModel: ListViewModel = viewModel()
) {
    val notes = viewModel.notes

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(1f))
            AppTitle(text = "Notes")
            Spacer(modifier = Modifier.weight(1f))
            CustomButton(text = "+", onClick = onAddClick)
        }

        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(notes) { item ->
                ItemCard(item) { onItemClick(item) }
            }
        }
    }
}