package com.example.todonote.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.todonote.NotesDatabase
import com.example.todonote.data.db_kotlin.NoteKotlin
import com.example.todonote.data.db_kotlin.NotesKotlinDatabase
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class MainKotlinViewModel(context: Context) : ViewModel() {
    private val db = NotesKotlinDatabase.getInstance(context)
    val notesList = db.coinPriceInfoDao().getAllNotes()

    fun insertNote(note: NoteKotlin) {
           db.coinPriceInfoDao().insertNote(note)
               .subscribeOn(Schedulers.io())
               .subscribe({

               }, {

               })
    }
}