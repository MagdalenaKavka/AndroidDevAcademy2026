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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import java.time.LocalDate

var nextId = 6
val SampleList = mutableStateListOf(
    Note("1", "Note1", "ABCDEFG", LocalDate.of(2026, 3, 30)),
    Note("2", "Note2", "1233455678", LocalDate.of(2026, 3, 30)),
    Note("3", "Note3", "UNIFEST", LocalDate.of(2026, 3, 30)),
    Note("4", "Note4", "Akademija", LocalDate.of(2026, 3, 30)),
    Note("5", "Note5", "FERIT", LocalDate.of(2026, 3, 30))
)


@Composable
fun HomeScreen(
    onItemClick: (Note) -> Unit,
    onAddClick: () -> Unit
) {
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
            items(SampleList) { item ->
                ItemCard(item) { onItemClick(item) }
            }
        }
    }
}