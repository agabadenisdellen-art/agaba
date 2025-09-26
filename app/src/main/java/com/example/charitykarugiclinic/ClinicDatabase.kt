package com.example.agabadenisclinic

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Patient::class, Doctor::class], version = 1, exportSchema = false)
abstract class ClinicDatabase : RoomDatabase() {

    abstract fun clinicDao(): ClinicDao

    companion object {
        @Volatile
        private var INSTANCE: ClinicDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ClinicDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ClinicDatabase::class.java,
                    "agaba_denis_clinic_database" // Corrected DB name
                )
                .addCallback(ClinicDatabaseCallback(scope))
                .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class ClinicDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.clinicDao())
                }
            }
        }

        suspend fun populateDatabase(clinicDao: ClinicDao) {
            // Add sample patients
            clinicDao.addPatient(Patient(name = "John Smith", age = 45, gender = "Male", details = "Complaining of chest pains."))
            clinicDao.addPatient(Patient(name = "Jane Doe", age = 32, gender = "Female", details = "Annual check-up."))
            clinicDao.addPatient(Patient(name = "Peter Jones", age = 67, gender = "Male", details = "Hypertension follow-up."))
            clinicDao.addPatient(Patient(name = "Mary Williams", age = 28, gender = "Female", details = "Prenatal check-up."))
            clinicDao.addPatient(Patient(name = "David Brown", age = 50, gender = "Male", details = "Allergic reaction."))
            clinicDao.addPatient(Patient(name = "Susan Davis", age = 19, gender = "Female", details = "Ankle sprain."))
            clinicDao.addPatient(Patient(name = "Michael Miller", age = 75, gender = "Male", details = "Diabetes monitoring."))
            clinicDao.addPatient(Patient(name = "Linda Wilson", age = 60, gender = "Female", details = "Knee replacement follow-up."))
            clinicDao.addPatient(Patient(name = "Robert Moore", age = 25, gender = "Male", details = "Sore throat and fever."))
            clinicDao.addPatient(Patient(name = "Patricia Taylor", age = 48, gender = "Female", details = "Migraine headache."))
            clinicDao.addPatient(Patient(name = "James Anderson", age = 35, gender = "Male", details = "Back pain."))
            clinicDao.addPatient(Patient(name = "Jennifer Thomas", age = 55, gender = "Female", details = "Osteoporosis screening."))

            // Add sample doctors
            clinicDao.addDoctor(Doctor(name = "Dr. Emily White", specialty = "Cardiologist", experience = 15))
            clinicDao.addDoctor(Doctor(name = "Dr. Ben Carter", specialty = "Pediatrician", experience = 10))
            clinicDao.addDoctor(Doctor(name = "Dr. Olivia Harris", specialty = "Dermatologist", experience = 8))
            clinicDao.addDoctor(Doctor(name = "Dr. Samuel Clark", specialty = "Orthopedic Surgeon", experience = 20))
            clinicDao.addDoctor(Doctor(name = "Dr. Grace Lewis", specialty = "Neurologist", experience = 12))
        }
    }
}