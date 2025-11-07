package com.unilifeai

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TimetableRepository(private val timetableDao: TimetableDao) {

    val allTimetableEntries = timetableDao.getAll()

    suspend fun prePopulateTimetableIfEmpty() {
        withContext(Dispatchers.IO) {
            if (timetableDao.count() == 0) {
                val timetable = getInitialTimetable()
                timetableDao.insertAll(timetable)
            }
        }
    }

    private fun getInitialTimetable(): List<TimetableEntry> {
        return listOf(
            // Monday
            TimetableEntry(day = "Monday", time = "09:00", subject = "Information Technology"),
            TimetableEntry(day = "Monday", time = "14:30", subject = "Business Process Modeling"),
            // Tuesday
            TimetableEntry(day = "Tuesday", time = "09:00", subject = "Cybersecurity"),
            TimetableEntry(day = "Tuesday", time = "19:00", subject = "Structured Programming"),
            // Friday
            TimetableEntry(day = "Friday", time = "09:00", subject = "Network & Enterprise Management"),
            // Saturday
            TimetableEntry(day = "Saturday", time = "09:00", subject = "Mobile Application")
        )
    }
}
