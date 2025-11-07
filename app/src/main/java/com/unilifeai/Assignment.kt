package com.unilifeai

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "assignments")
data class Assignment(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val subject: String,
    val title: String,
    val deadline: Date
)
