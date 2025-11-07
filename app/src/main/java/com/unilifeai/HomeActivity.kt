package com.unilifeai

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import java.util.*

class HomeActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var tts: TextToSpeech

    private lateinit var textViewGreeting: TextView
    private lateinit var textViewNextClass: TextView
    private lateinit var buttonAlarms: Button
    private lateinit var buttonShopping: Button
    private lateinit var buttonNotes: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        tts = TextToSpeech(this, this)

        val database = (application as UniLifeApplication).database
        val repository = TimetableRepository(database.timetableDao())
        val factory = HomeViewModelFactory(repository)
        homeViewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)

        textViewGreeting = findViewById(R.id.textViewGreeting)
        textViewNextClass = findViewById(R.id.textViewNextClass)
        buttonAlarms = findViewById(R.id.buttonAlarms)
        buttonShopping = findViewById(R.id.buttonShopping)
        buttonNotes = findViewById(R.id.buttonNotes)

        // --- Set Greeting ---
        val studentName = "Denis" // This would be fetched from SharedPreferences
        val greeting = GreetingHelper.getGreeting(studentName)
        textViewGreeting.text = greeting
        speak(greeting)

        // --- Observe Timetable for Next Class ---
        homeViewModel.timetableEntries.observe(this, { timetable ->
            timetable?.let {
                val nextClass = GreetingHelper.getNextClassReminder(it)
                textViewNextClass.text = nextClass
            }
        })

        // --- Button Navigation ---
        buttonAlarms.setOnClickListener {
            startActivity(Intent(this, AlarmActivity::class.java))
        }
        buttonShopping.setOnClickListener {
            startActivity(Intent(this, ShoppingActivity::class.java))
        }
        buttonNotes.setOnClickListener {
            startActivity(Intent(this, NotesActivity::class.java))
        }
    }

    private fun speak(text: String) {
        if (tts.isSpeaking) {
            tts.stop()
        }
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.language = Locale.US
        }
    }

    override fun onDestroy() {
        if (tts.isSpeaking) {
            tts.stop()
        }
        tts.shutdown()
        super.onDestroy()
    }
}
