package com.kavkamagdalena.notes.ui.theme

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

enum class SortOrder {
    NONE, A_TO_Z, Z_TO_A
}

class TaskListViewModel : ViewModel() {
    private val logger = AppContainer.logger
    private val allTasks = mutableStateListOf<Task>()
    val tasks = mutableStateListOf<Task>()
    var isLoading = mutableStateOf(false)
    var sortOrder = mutableStateOf(SortOrder.NONE)

    fun loadTasks() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                val result = RetrofitClient.api.getTasks(TokenStorage.token)
                allTasks.clear()
                allTasks.addAll(result)
                applySort()
                logger.logI("loadTasks: loaded ${result.size} tasks")
            } catch (e: Exception) {
                logger.logE("loadTasks error: ${e.message}")
            } finally {
                isLoading.value = false
            }
        }
    }

    fun setSort(order: SortOrder) {
        sortOrder.value = order
        applySort()
        logger.logD("setSort: sort changed to $order")
    }

    private fun applySort() {
        val sorted = when (sortOrder.value) {
            SortOrder.A_TO_Z -> allTasks.sortedBy { it.title }
            SortOrder.Z_TO_A -> allTasks.sortedByDescending { it.title }
            SortOrder.NONE -> allTasks.toList()
        }
        tasks.clear()
        tasks.addAll(sorted)
    }

    fun deleteTask(id: Int) {
        viewModelScope.launch {
            try {
                RetrofitClient.api.deleteTask(TokenStorage.token, id)
                allTasks.removeIf { it.id == id }
                tasks.removeIf { it.id == id }
                logger.logI("deleteTask: deleted task $id")
            } catch (e: Exception) {
                logger.logE("deleteTask error: ${e.message}")
            }
        }
    }
}