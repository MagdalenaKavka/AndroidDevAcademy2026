package com.kavkamagdalena.notes.ui.theme

import androidx.lifecycle.ViewModel
import java.time.LocalDate

class EditViewModel : ViewModel() {
    private val repository = NoteRepository()

    fun save(id: String?, title: String, description: String) {
        if (id == null) {
            repository.add(
                Note(
                    ID = nextId.toString(),
                    title = title,
                    description = description,
                    date = LocalDate.now()
                )
            )
        } else {
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