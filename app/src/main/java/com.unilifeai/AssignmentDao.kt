package com.unilifeai

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface AssignmentDao {
    @Insert
    suspend fun insert(assignment: Assignment)

    @Update
    suspend fun update(assignment: Assignment)

    @Delete
    suspend fun delete(assignment: Assignment)

    @Query("SELECT * FROM assignments ORDER BY deadline")
    fun getAll(): Flow<List<Assignment>>

    @Query("SELECT * FROM assignments WHERE deadline > :date ORDER BY deadline ASC")
    fun getUpcoming(date: Date): Flow<List<Assignment>>
}
