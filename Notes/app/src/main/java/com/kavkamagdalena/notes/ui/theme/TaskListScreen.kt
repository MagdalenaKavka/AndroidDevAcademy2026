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

    // Dialog za brisanje
    if (taskToDelete != null) {
        AlertDialog(
            onDismissRequest = { taskToDelete = null },
            title = { Text("Obriši task") },
            text = { Text("Jesi li siguran da želiš obrisati '${taskToDelete?.title}'?") },
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

        if (viewModel.isLoading) {
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