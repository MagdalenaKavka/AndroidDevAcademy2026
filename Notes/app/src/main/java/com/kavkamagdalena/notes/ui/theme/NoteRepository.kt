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

class NoteRepository(private val logger: AppLogger) {
    fun getAll(): List<Note> {
        logger.logD("getAll: returning ${SampleList.size} notes")
        return SampleList
    }

    fun add(note: Note) {
        SampleList.add(note)
        nextId++
        logger.logI("add: added note ${note.title}")
    }

    fun update(note: Note) {
        val index = SampleList.indexOfFirst { it.ID == note.ID }
        if (index != -1) {
            SampleList[index] = note
            logger.logI("update: updated note ${note.title}")
        } else {
            logger.logW("update: note with ID ${note.ID} not found")
        }
    }
}