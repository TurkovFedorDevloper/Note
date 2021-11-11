package com.example.todonote.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.todonote.Note
import com.example.todonote.R
import com.example.todonote.data.db_kotlin.NoteKotlin
import com.example.todonote.presentation.adapters.NotesAdapterKotlin
import java.util.*

class MainKotlinActivity : AppCompatActivity() {

    private lateinit var vm: MainKotlinViewModel
    private lateinit var recyclerViewNotes: RecyclerView
    private var notes = ArrayList<NoteKotlin>()
    private var adapter = NotesAdapterKotlin()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kotlin)
        init()
    }

    private fun init() {
        initViewModel()
        recyclerViewNotes = findViewById(R.id.recyclerViewNotesKotlin)
        recyclerViewNotes.adapter = adapter
        adapter.onNoteClickListener = object : NotesAdapterKotlin.OnNoteClickListener {

            override fun onNoteClick(note: NoteKotlin) {
                Toast.makeText(this@MainKotlinActivity, note.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(note: NoteKotlin) {
                Toast.makeText(this@MainKotlinActivity, note.toString(), Toast.LENGTH_SHORT).show()

            }
        }

        vm.insertNote(NoteKotlin(1, "0", "0", 0, 0))
        vm.insertNote(NoteKotlin(2, "1", "1", 1, 1))
        vm.insertNote(NoteKotlin(3, "2", "2", 2, 2))
        vm.insertNote(NoteKotlin(4, "3", "3", 3, 0))
        vm.insertNote(NoteKotlin(5, "4", "4", 4, 1))
        vm.insertNote(NoteKotlin(6, "5", "5", 5, 2))
        adapter.notifyDataSetChanged()
    }

    private fun initViewModel() {
        vm = ViewModelProvider(
            this,
            MainKotlinViewModelFactory(this)
        )[MainKotlinViewModel::class.java]

        vm.notesList.observe(this, {
            adapter.notes = it
        })
    }

//
//    private fun addNotesTest() {
//        notes.add(NoteKotlin(0, "0", "0", 0, 0))
//        notes.add(NoteKotlin(1, "1", "1", 1, 1))
//        notes.add(NoteKotlin(2, "2", "2", 2, 2))
//        notes.add(NoteKotlin(3, "3", "3", 3, 0))
//        notes.add(NoteKotlin(4, "4", "4", 4, 1))
//        notes.add(NoteKotlin(5, "5", "5", 5, 2))
//        adapter.notes = notes
//    }
}