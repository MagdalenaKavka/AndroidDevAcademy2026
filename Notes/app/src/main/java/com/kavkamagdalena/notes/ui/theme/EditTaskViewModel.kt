package com.kavkamagdalena.notes.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EditTaskViewModel : ViewModel() {
    private val logger = AppContainer.logger
    var title = mutableStateOf("")
    var body = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun loadTask(id: Int) {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val task = RetrofitClient.api.getTask(TokenStorage.token, id)
                title.value = task.title
                body.value = task.body
                logger.logI("loadTask: loaded task $id")
            } catch (e: Exception) {
                logger.logE("loadTask error: ${e.message}")
            } finally {
                isLoading.value = false
            }
        }
    }

    fun save(id: Int?, onSuccess: () -> Unit) {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val request = CreateTaskRequest(title.value, body.value)
                if (id == null) {
                    RetrofitClient.api.createTask(TokenStorage.token, request)
                    logger.logI("save: created new task '${title.value}'")
                } else {
                    RetrofitClient.api.updateTask(TokenStorage.token, id, request)
                    logger.logI("save: updated task $id")
                }
                onSuccess()
            } catch (e: Exception) {
                logger.logE("save error: ${e.message}")
            } finally {
                isLoading.value = false
            }
        }
    }
}