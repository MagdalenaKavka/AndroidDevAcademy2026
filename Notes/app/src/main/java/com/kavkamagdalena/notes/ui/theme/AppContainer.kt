package com.kavkamagdalena.notes.ui.theme

object AppContainer {
    val logger = AppLogger("NotesApp")
    val repository = NoteRepository(logger)
    val retrofitClient = RetrofitClient
    val tokenStorage = TokenStorage
}