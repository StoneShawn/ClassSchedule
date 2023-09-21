package com.shawn.data.repository

import com.shawn.data.util.Syncable
import com.shawn.model.Course
import kotlinx.coroutines.flow.Flow

interface CourseRepository: Syncable {

    fun getCourseStream(): Flow<List<Course>>

    suspend fun toggleSaveCourse(saveCourseId: Int, saved: String): Int
}