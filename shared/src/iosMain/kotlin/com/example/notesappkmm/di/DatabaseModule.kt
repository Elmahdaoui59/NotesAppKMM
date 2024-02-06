package com.example.notesappkmm.di

import com.example.noteappkmm.db.NoteDatabase
import com.example.notesappkmm.data.local.DatabaseDriverFactory
import com.example.notesappkmm.data.note.SqlDelightNoteDataSource
import com.example.notesappkmm.domain.note.NoteDataSource

class DatabaseModule {
    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }
}