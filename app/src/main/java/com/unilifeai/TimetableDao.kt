package com.unilifeai

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TimetableDao {
    @Insert
    suspend fun insertAll(entries: List<TimetableEntry>)

    @Query("SELECT * FROM timetable ORDER BY day, time")
    fun getAll(): Flow<List<TimetableEntry>>

    @Query("SELECT * FROM timetable WHERE day = :day ORDER BY time")
    fun getForDay(day: String): Flow<List<TimetableEntry>>

    @Query("SELECT COUNT(*) FROM timetable")
    suspend fun count(): Int
}
