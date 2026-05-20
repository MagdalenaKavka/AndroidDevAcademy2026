package com.kavkamagdalena.notes.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TaskListScreen(
    onTaskClick: (Int) -> Unit,
    onAddClick: () -> Unit,
    viewModel: TaskListViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.loadTasks()
    }

    var taskToDelete by remember { mutableStateOf<Task?>(null) }
    val currentSort by viewModel.sortOrder

    if (taskToDelete != null) {
        AlertDialog(
            onDismissRequest = { taskToDelete = null },
            title = { Text("Obriši task") },
            text = { Text("Jesi li sigurna da želiš obrisati '${taskToDelete?.title}'?") },
            confirmButton = {
                TextButton(onClick = {
                    viewModel.deleteTask(taskToDelete!!.id)
                    taskToDelete = null
                }) { Text("Obriši") }
            },
            dismissButton = {
                TextButton(onClick = { taskToDelete = null }) { Text("Odustani") }
            }
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(1f))
            AppTitle(text = "Tasks")
            Spacer(modifier = Modifier.weight(1f))
            CustomButton(text = "+", onClick = onAddClick)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = currentSort == SortOrder.NONE,
                onClick = { viewModel.setSort(SortOrder.NONE) },
                label = { Text("Zadano") }
            )
            FilterChip(
                selected = currentSort == SortOrder.A_TO_Z,
                onClick = { viewModel.setSort(SortOrder.A_TO_Z) },
                label = { Text("A → Z") }
            )
            FilterChip(
                selected = currentSort == SortOrder.Z_TO_A,
                onClick = { viewModel.setSort(SortOrder.Z_TO_A) },
                label = { Text("Z → A") }
            )
        }

        if (viewModel.isLoading.value) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(viewModel.tasks) { task ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .combinedClickable(
                                onClick = { onTaskClick(task.id) },
                                onLongClick = { taskToDelete = task }
                            )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            TitleText(text = task.title)
                            DescriptionText(text = task.body)
                        }
                    }
                }
            }
        }
    }
}