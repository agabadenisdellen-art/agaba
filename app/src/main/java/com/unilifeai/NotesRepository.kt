package com.unilifeai

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotesRepository(private val noteDao: NoteDao) {

    val allNotes = noteDao.getAll()

    suspend fun insert(note: Note) {
        withContext(Dispatchers.IO) {
            noteDao.insert(note)
        }
    }

    // Update and Delete can be added here if needed
}
