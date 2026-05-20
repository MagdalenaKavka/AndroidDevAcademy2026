package com.kavkamagdalena.notes.ui.theme

import androidx.lifecycle.ViewModel
import java.time.LocalDate

class EditViewModel(
    private val repository: NoteRepository = AppContainer.repository
) : ViewModel() {
    private val logger = AppContainer.logger

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