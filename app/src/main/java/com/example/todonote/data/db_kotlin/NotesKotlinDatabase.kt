package com.example.todonote.data.db_kotlin

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteKotlin::class], version = 1, exportSchema = false)
abstract class NotesKotlinDatabase : RoomDatabase() {
        companion object {

            private const val DB_NAME = "coin.db"
            private val LOCK = Any()
            private var db: NotesKotlinDatabase? = null

            fun getInstance(context: Context): NotesKotlinDatabase {
                synchronized(LOCK) {
                    db?.let { return it }
                    val instance =
                        Room.databaseBuilder(context, NotesKotlinDatabase::class.java, DB_NAME).build()
                    db = instance
                    return instance
                }
            }
        }
        abstract fun coinPriceInfoDao(): NotesKotlinDao
}