package com.example.todonote.data.db_kotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_kotlin")
data class NoteKotlin(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String? = null,
    val description: String? = null,
    val dayOfWeek: Int? = null,
    val priority: Int? = null
)
