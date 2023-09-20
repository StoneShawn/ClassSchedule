package com.shawn.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.shawn.database.dao.CourseDao
import com.shawn.database.model.CourseEntity
import com.shawn.database.util.SuccessCriteriaTypeConverter


@Database(
    entities = [
        CourseEntity::class
    ],
    version = 1,
)
@TypeConverters(
    SuccessCriteriaTypeConverter::class
)
abstract class Database: RoomDatabase() {
    abstract fun courseDao(): CourseDao
}