package com.example.todonote.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.todonote.data.db_kotlin.NoteKotlin
import com.example.todonote.data.db_kotlin.NotesKotlinDatabase
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainKotlinViewModel(context: Context) : ViewModel() {
    private val db = NotesKotlinDatabase.getInstance(context)
    private var compositeDisposable = CompositeDisposable()
    val notesList = db.coinPriceInfoDao().getAllNotes()

    fun insertNote(note: NoteKotlin) {
        compositeDisposable.add(
            Single.just(db)
            .subscribeOn(Schedulers.io())
            .subscribe({ db ->
                db.coinPriceInfoDao().insertNote(note = note)
            }, {})
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}