package com.kavkamagdalena.notes.ui.theme

import androidx.lifecycle.ViewModel
import java.time.LocalDate

class EditViewModel : ViewModel() {
    private val logger = AppContainer.logger
    private val repository = AppContainer.repository

    fun save(id: String?, title: String, description: String) {
        if (id == null) {
            logger.logI("save: creating new note '$title'")
            repository.add(
                Note(
                    ID = nextId.toString(),
                    title = title,
                    description = description,
                    date = LocalDate.now()
                )
            )
        } else {
            logger.logI("save: updating note with ID $id")
            repository.update(
                Note(
                    ID = id,
                    title = title,
                    description = description,
                    date = LocalDate.now()
                )
            )
        }
    }
}