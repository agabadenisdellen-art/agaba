package com.example.agabadenisclinic

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ClinicDao {

    // --- Patient Queries ---

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPatient(patient: Patient)

    @Query("SELECT * FROM patients ORDER BY name ASC")
    fun getAllPatients(): Flow<List<Patient>>

    // --- Doctor Queries ---

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDoctor(doctor: Doctor)

    @Query("SELECT * FROM doctors ORDER BY name ASC")
    fun getAllDoctors(): Flow<List<Doctor>>
}