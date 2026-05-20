package com.kavkamagdalena.notes.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun EditTaskScreen(
    taskId: Int?,
    onBackClick: () -> Unit,
    viewModel: EditTaskViewModel = viewModel()
) {
    LaunchedEffect(taskId) {
        if (taskId != null) viewModel.loadTask(taskId)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Row(horizontalArrangement = Arrangement.Start) {
            CustomButton(text = "<-", onClick = onBackClick)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = viewModel.title.value,
            onValueChange = { viewModel.title.value = it },
            placeholder = { TitleText(text = "Title") },
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = viewModel.body.value,
            onValueChange = { viewModel.body.value = it },
            placeholder = { DescriptionText(text = "Body") },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            maxLines = 10
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            CustomButton(
                text = "Done",
                onClick = { viewModel.save(taskId, onBackClick) }
            )
        }
    }
}