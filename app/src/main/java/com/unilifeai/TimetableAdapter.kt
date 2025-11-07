package com.unilifeai

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TimetableAdapter(private val timetableEntries: List<TimetableEntry>) : RecyclerView.Adapter<TimetableAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dayTextView: TextView = view.findViewById(R.id.dayTextView)
        val timeTextView: TextView = view.findViewById(R.id.timeTextView)
        val subjectTextView: TextView = view.findViewById(R.id.subjectTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_timetable_entry, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = timetableEntries[position]
        holder.dayTextView.text = entry.day
        holder.timeTextView.text = entry.time
        holder.subjectTextView.text = entry.subject
    }

    override fun getItemCount() = timetableEntries.size
}
