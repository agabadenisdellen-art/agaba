package com.unilifeai

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AlarmRepository(private val alarmDao: AlarmDao) {

    val allAlarms = alarmDao.getAll()

    suspend fun insert(alarm: Alarm) {
        withContext(Dispatchers.IO) {
            alarmDao.insert(alarm)
        }
    }

    suspend fun update(alarm: Alarm) {
        withContext(Dispatchers.IO) {
            alarmDao.update(alarm)
        }
    }

    suspend fun delete(alarm: Alarm) {
        withContext(Dispatchers.IO) {
            alarmDao.delete(alarm)
        }
    }
}
