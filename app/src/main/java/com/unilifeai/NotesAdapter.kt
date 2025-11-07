package com.unilifeai

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private var notes: List<Note>) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val subjectTextView: TextView = view.findViewById(R.id.textViewNoteSubject)
        val contentTextView: TextView = view.findViewById(R.id.textViewNoteContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.subjectTextView.text = note.subject
        holder.contentTextView.text = note.content
    }

    override fun getItemCount() = notes.size

    fun updateData(newNotes: List<Note>) {
        notes = newNotes
        notifyDataSetChanged()
    }
}
