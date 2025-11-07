package com.unilifeai

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [TimetableEntry::class, Alarm::class, ShoppingItem::class, Note::class, Assignment::class], version = 1)
@TypeConverters(Converters::class) // We'll create this file next for the Date type
abstract class AppDatabase : RoomDatabase() {
    abstract fun timetableDao(): TimetableDao
    abstract fun alarmDao(): AlarmDao
    abstract fun shoppingItemDao(): ShoppingItemDao
    abstract fun noteDao(): NoteDao
    abstract fun assignmentDao(): AssignmentDao
}
