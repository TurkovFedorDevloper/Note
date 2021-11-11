package com.example.todonote.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todonote.R
import com.example.todonote.data.db_kotlin.NoteKotlin

class NotesAdapterKotlin : RecyclerView.Adapter<NotesAdapterKotlin.NotesViewHolder>() {

    var notes = listOf<NoteKotlin>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onNoteClickListener: OnNoteClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.note_item_kotlin,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note = note)
    }

    override fun getItemCount() = notes.size

    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        private val tvDescription: TextView = itemView.findViewById(R.id.textViewDescription)
        private val tvDayOfWeek: TextView = itemView.findViewById(R.id.textViewDayOfWeek)

        @SuppressLint("ResourceType")
        fun bind(note: NoteKotlin) {
            tvTitle.text = note.title
            tvDescription.text = note.description
            tvDayOfWeek.text = note.dayOfWeek?.plus(1)?.let { getDayAsString(it) }
            val colorId = when (note.priority) {
                1 -> itemView.resources.getColor(R.color.red)
                2 -> itemView.resources.getColor(R.color.orange)
                else -> itemView.resources.getColor(R.color.green)
            }
            tvTitle.setBackgroundColor(colorId)

            itemView.setOnClickListener {
                onNoteClickListener?.onNoteClick(note)
                onNoteClickListener?.onLongClick(note)
            }
        }
    }

    fun getDayAsString(position: Int): String {
        return when (position) {
            1 -> "Понедельник"
            2 -> "Вторник"
            3 -> "Среда"
            4 -> "Четверг"
            5 -> "Пятница"
            6 -> "Суббота"
            else -> "Воскресенье"
        }
    }

    interface OnNoteClickListener {
        fun onNoteClick(note: NoteKotlin)
        fun onLongClick(note: NoteKotlin)
    }
}