package com.shawn.data.repository

import com.shawn.data.model.asEntity
import com.shawn.database.dao.CourseDao
import com.shawn.database.model.CourseEntity
import com.shawn.database.model.asExternalModel
import com.shawn.model.Course
import com.shawn.network.model.NetworkCourse
import com.shawn.network.retrofit.RetrofitNetwork
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * 實作 [CourseRepository]
 * 使用syncWith 與 sync module 利用workmanager 在[MainApplication]App執行時在後台執行
 */
class OfflineFirstCourseRepository(
    private val courseDao: CourseDao,
    private val network: RetrofitNetwork,
) : CourseRepository {
    override fun getCourseStream(): Flow<List<Course>> {
        return courseDao.getCourseListEntitiesStream().map {
            it.map(CourseEntity::asExternalModel)
        }
    }

    override suspend fun toggleSaveCourse(saveCourseId: Int, saved: String): Int {
        return courseDao.updateCourseSave(saveCourseId, saved)
    }

    override suspend fun syncWith(): Boolean {
        courseDao.insertOrIgnoreCourse(
            courseEntities = network.getCourse()
                .map(NetworkCourse::asEntity)
        )
        return true
    }
}