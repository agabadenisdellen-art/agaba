package com.unilifeai

import android.app.Application
import androidx.room.Room

class UniLifeApplication : Application() {
    // Using by lazy so the database is only created when needed
    val database: AppDatabase by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java, "unilife-db"
        ).build()
    }
}
