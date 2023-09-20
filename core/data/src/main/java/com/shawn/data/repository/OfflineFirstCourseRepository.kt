package com.shawn.data.repository

import com.shawn.data.model.asEntity
import com.shawn.database.dao.CourseDao
import com.shawn.database.model.CourseEntity
import com.shawn.database.model.asExternalModel
import com.shawn.model.Course
import com.shawn.network.model.NetworkCourse
import com.shawn.network.retrofit.RetrofitNetwork
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class OfflineFirstCourseRepository(

    private val courseDao: CourseDao,
    private val network: RetrofitNetwork
) : CourseRepository {
    override fun getCourseStream(): Flow<List<Course>> {
        GlobalScope.launch {
            syncWith()
        }
        return courseDao.getCourseListEntitiesStream().map {
            it.map(CourseEntity::asExternalModel)
        }
    }

    override suspend fun syncWith(): Boolean {
        courseDao.upsertCourse(entities = network.getCourse().map(NetworkCourse::asEntity))
        return true
    }
}