package com.kavkamagdalena.notes.ui.theme

import androidx.compose.runtime.mutableStateListOf
import java.time.LocalDate


val SampleList = mutableStateListOf(
    Note("1", "Note1", "ABCDEFG", LocalDate.of(2026, 3, 30)),
    Note("2", "Note2", "1233455678", LocalDate.of(2026, 3, 30)),
    Note("3", "Note3", "UNIFEST", LocalDate.of(2026, 3, 30)),
    Note("4", "Note4", "Akademija", LocalDate.of(2026, 3, 30)),
    Note("5", "Note5", "FERIT", LocalDate.of(2026, 3, 30))
)

var nextId = 6

class NoteRepository {
    fun getAll() = SampleList

    fun add(note: Note) {
        SampleList.add(note)
        nextId++
    }

    fun update(note: Note) {
        val index = SampleList.indexOfFirst { it.ID == note.ID }
        if (index != -1) SampleList[index] = note
    }
}