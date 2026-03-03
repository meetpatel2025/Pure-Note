package com.training.purenote.repository

import com.training.purenote.database.NoteDatabase
import com.training.purenote.model.Note

class NoteRepository(private val db: NoteDatabase) {

    suspend fun isertNote(note : Note) = db.getNoteDao().insertNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)

    fun getAllNotes() = db.getNoteDao().getAllNotes()
    fun searchNotes(query:String?) =  db.getNoteDao().searchNote(query)
}