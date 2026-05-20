package com.kavkamagdalena.notes.ui.theme

import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    private val logger = AppContainer.logger
    private val repository = AppContainer.repository

    val notes = repository.getAll()

    init {
        logger.logD("ListViewModel created")
    }
}