package com.example.todonote.data.db_kotlin

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todonote.Note
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface NotesKotlinDao {

    @Query("SELECT * FROM notes_kotlin ORDER BY priority")
    fun getAllNotes(): LiveData<List<NoteKotlin>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: NoteKotlin): Completable

    @Delete
    fun deleteNote(note: NoteKotlin)

    @Query("DELETE FROM notes_kotlin")
    fun deleteAllNotes()
}