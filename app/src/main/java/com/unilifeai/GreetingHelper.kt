package com.unilifeai

import java.text.SimpleDateFormat
import java.util.*

object GreetingHelper {

    fun getGreeting(name: String): String {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return when (hour) {
            in 5..11 -> "Good morning, $name! ☕"
            in 12..16 -> "Good afternoon, $name!"
            in 17..21 -> "Good evening, $name! 📚"
            else -> "Good night, $name! 😴"
        }
    }

    fun getNextClassReminder(timetable: List<TimetableEntry>): String {
        val calendar = Calendar.getInstance()
        val dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = calendar.time

        val upcomingClass = timetable
            .filter { it.day.equals(dayOfWeek, ignoreCase = true) }
            .mapNotNull {
                try {
                    val classTime = timeFormat.parse(it.time)
                    if (classTime.after(currentTime)) it else null
                } catch (e: Exception) {
                    null
                }
            }
            .minByOrNull { timeFormat.parse(it.time).time }

        return upcomingClass?.let {
            "${it.subject} at ${it.time}"
        } ?: "No more classes today!"
    }
}
