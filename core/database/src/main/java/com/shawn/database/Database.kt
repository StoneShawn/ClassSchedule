package com.shawn.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shawn.database.dao.CourseDao
import com.shawn.database.model.CourseEntity


@Database(
    entities = [
        CourseEntity::class
    ],
    version = 1,
)
abstract class Database: RoomDatabase() {
    abstract fun courseDao(): CourseDao
}