package com.example.notesappkmm.android.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import com.example.noteappkmm.db.NoteDatabase
import com.example.notesappkmm.data.local.DatabaseDriverFactory
import com.example.notesappkmm.data.note.SqlDelightNoteDataSource
import com.example.notesappkmm.domain.note.NoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }
    @Provides
    @Singleton
    fun provideNoteDataSource(driver: SqlDriver): NoteDataSource {
        return SqlDelightNoteDataSource(NoteDatabase(driver))
    }
}