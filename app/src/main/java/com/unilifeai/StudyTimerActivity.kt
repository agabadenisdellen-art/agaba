package com.unilifeai

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit

class StudyTimerActivity : AppCompatActivity() {

    private lateinit var textViewTimer: TextView
    private lateinit var buttonStart: Button
    private lateinit var buttonPause: Button
    private lateinit var buttonReset: Button

    private var countDownTimer: CountDownTimer? = null
    private var timeLeftInMillis: Long = TimeUnit.MINUTES.toMillis(25)
    private var isTimerRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_timer)

        textViewTimer = findViewById(R.id.textViewTimer)
        buttonStart = findViewById(R.id.buttonStart)
        buttonPause = findViewById(R.id.buttonPause)
        buttonReset = findViewById(R.id.buttonReset)

        updateTimerText()

        buttonStart.setOnClickListener {
            if (!isTimerRunning) {
                startTimer()
            }
        }

        buttonPause.setOnClickListener {
            pauseTimer()
        }

        buttonReset.setOnClickListener {
            resetTimer()
        }
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateTimerText()
            }

            override fun onFinish() {
                isTimerRunning = false
                // Handle timer finish (e.g., start break, play sound)
            }
        }.start()
        isTimerRunning = true
    }

    private fun pauseTimer() {
        countDownTimer?.cancel()
        isTimerRunning = false
    }

    private fun resetTimer() {
        pauseTimer()
        timeLeftInMillis = TimeUnit.MINUTES.toMillis(25)
        updateTimerText()
    }

    private fun updateTimerText() {
        val minutes = TimeUnit.MILLISECONDS.toMinutes(timeLeftInMillis)
        val seconds = TimeUnit.MILLISECONDS.toSeconds(timeLeftInMillis) % 60
        val timeFormatted = String.format("%02d:%02d", minutes, seconds)
        textViewTimer.text = timeFormatted
    }
}
