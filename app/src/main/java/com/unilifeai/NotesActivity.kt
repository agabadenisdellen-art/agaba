package com.unilifeai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NotesActivity : AppCompatActivity() {

    private lateinit var notesViewModel: NotesViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NotesAdapter
    private lateinit var fabAddNote: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        val database = (application as UniLifeApplication).database
        val repository = NotesRepository(database.noteDao())
        val factory = NotesViewModelFactory(repository)
        notesViewModel = ViewModelProvider(this, factory).get(NotesViewModel::class.java)

        recyclerView = findViewById(R.id.recyclerViewNotes)
        recyclerView.layoutManager = LinearLayoutManager(this)

        notesViewModel.allNotes.observe(this, { notes ->
            notes?.let {
                if (!::adapter.isInitialized) {
                    adapter = NotesAdapter(it)
                    recyclerView.adapter = adapter
                } else {
                    adapter.updateData(it)
                }
            }
        })

        fabAddNote = findViewById(R.id.fabAddNote)
        fabAddNote.setOnClickListener {
            showAddNoteDialog()
        }
    }

    private fun showAddNoteDialog() {
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Add New Note")

        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_add_note, null)
        val subjectEditText = dialogLayout.findViewById<android.widget.EditText>(R.id.editTextNoteSubject)
        val contentEditText = dialogLayout.findViewById<android.widget.EditText>(R.id.editTextNoteContent)

        builder.setView(dialogLayout)

        builder.setPositiveButton("Add") { dialog, which ->
            val subject = subjectEditText.text.toString()
            val content = contentEditText.text.toString()
            if (subject.isNotBlank() && content.isNotBlank()) {
                notesViewModel.insert(Note(subject = subject, content = content))
            }
        }
        builder.setNegativeButton("Cancel", null)

        builder.create().show()
    }
}
