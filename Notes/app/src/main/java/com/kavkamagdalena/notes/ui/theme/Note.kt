package com.kavkamagdalena.notes.ui.theme

import java.time.LocalDate

data class Note (
    val ID: String,
    val title: String,
    val description: String,
    val date: LocalDate = LocalDate.now()
)