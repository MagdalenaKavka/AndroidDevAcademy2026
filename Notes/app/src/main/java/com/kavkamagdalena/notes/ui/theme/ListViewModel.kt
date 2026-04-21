package com.kavkamagdalena.notes.ui.theme

import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    private val repository = NoteRepository()

    val notes = repository.getAll()
}