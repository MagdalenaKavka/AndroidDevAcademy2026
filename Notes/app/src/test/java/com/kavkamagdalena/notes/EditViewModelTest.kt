package com.kavkamagdalena.notes

import com.kavkamagdalena.notes.ui.theme.AppLogger
import com.kavkamagdalena.notes.ui.theme.EditViewModel
import com.kavkamagdalena.notes.ui.theme.NoteRepository
import com.kavkamagdalena.notes.ui.theme.SampleList
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class EditViewModelTest {

    private lateinit var viewModel: EditViewModel
    private lateinit var repository: NoteRepository
    private lateinit var logger: AppLogger

    @Before
    fun setup() {
        logger = mockk(relaxed = true)
        repository = NoteRepository(logger)
        SampleList.clear()
        viewModel = EditViewModel(repository)
    }

    @Test
    fun `save with null id adds new note`() {
        viewModel.save(id = null, title = "Nova bilješka", description = "Opis")
        assertEquals(1, SampleList.size)
        assertEquals("Nova bilješka", SampleList.first().title)
    }

    @Test
    fun `save with existing id updates note`() {
        viewModel.save(id = null, title = "Originalna", description = "Opis")
        val id = SampleList.first().ID

        viewModel.save(id = id, title = "Izmijenjena", description = "Novi opis")

        assertEquals(1, SampleList.size)
        assertEquals("Izmijenjena", SampleList.first().title)
    }
}