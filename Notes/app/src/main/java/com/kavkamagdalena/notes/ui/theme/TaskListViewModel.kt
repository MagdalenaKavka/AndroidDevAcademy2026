package com.kavkamagdalena.notes.ui.theme

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskListViewModel : ViewModel() {
    private val logger = AppContainer.logger
    val tasks = mutableStateListOf<Task>()
    var isLoading = mutableStateOf(false)

    fun loadTasks() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val result = RetrofitClient.api.getTasks(TokenStorage.token)
                tasks.clear()
                tasks.addAll(result)
                logger.logI("loadTasks: loaded ${result.size} tasks")
            } catch (e: Exception) {
                logger.logE("loadTasks error: ${e.message}")
            } finally {
                isLoading.value = false
            }
        }
    }

    fun deleteTask(id: Int) {
        viewModelScope.launch {
            try {
                RetrofitClient.api.deleteTask(TokenStorage.token, id)
                tasks.removeIf { it.id == id }
                logger.logI("deleteTask: deleted task $id")
            } catch (e: Exception) {
                logger.logE("deleteTask error: ${e.message}")
            }
        }
    }
}