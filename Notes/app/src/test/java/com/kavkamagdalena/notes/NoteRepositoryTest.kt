package com.kavkamagdalena.notes

import com.kavkamagdalena.notes.ui.theme.AppLogger
import com.kavkamagdalena.notes.ui.theme.Note
import com.kavkamagdalena.notes.ui.theme.NoteRepository
import com.kavkamagdalena.notes.ui.theme.SampleList
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class NoteRepositoryTest {

    private lateinit var repository: NoteRepository
    private lateinit var logger: AppLogger

    @Before
    fun setup() {
        logger = mockk(relaxed = true)
        repository = NoteRepository(logger)
        SampleList.clear()
    }

    @Test
    fun `getAll returns empty list when no notes`() {
        val result = repository.getAll()
        assertTrue(result.isEmpty())
    }

    @Test
    fun `add note increases list size`() {
        val note = Note("10", "Test", "Opis", LocalDate.now())
        repository.add(note)
        assertEquals(1, repository.getAll().size)
    }

    @Test
    fun `update note changes title`() {
        val note = Note("10", "Stari naslov", "Opis", LocalDate.now())
        repository.add(note)

        val updated = note.copy(title = "Novi naslov")
        repository.update(updated)

        assertEquals("Novi naslov", repository.getAll().first().title)
    }

    @Test
    fun `update note that doesnt exist does nothing`() {
        val note = Note("999", "Ne postoji", "Opis", LocalDate.now())
        repository.update(note)
        assertTrue(repository.getAll().isEmpty())
    }
}