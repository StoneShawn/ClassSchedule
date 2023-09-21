package com.shawn.database.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.shawn.database.AppDatabase
import com.shawn.database.model.CourseEntity
import com.shawn.database.model.asExternalModel
import com.shawn.model.SuccessCriteria
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CourseDaoTest {

    private lateinit var courseDao: CourseDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        ).build()

        courseDao = db.courseDao()
    }

    @Test
    fun courseDao_insert_data() = runTest {
        val courseEntity = listOf(
            testNewsResource(1),
            testNewsResource(2)
        )

        courseDao.insertOrIgnoreCourse(courseEntity)

        val savedCourseEntities = courseDao.getCourseListEntitiesStream().first()

        assertEquals(
            listOf(1, 2),
            savedCourseEntities.map {
                it.asExternalModel().id
            }
        )
    }

    @Test
    fun courseDao_update_save_item() = runTest {
        val courseEntity = listOf(
            testNewsResource(1),
            testNewsResource(2)
        )

        courseDao.insertOrIgnoreCourse(courseEntity)

        courseDao.updateCourseSave(1,"true")


        val savedCourseEntities = courseDao.getCourseListEntitiesStream().first()

        assertEquals(
            listOf("true", ""),
            savedCourseEntities.map {
                it.asExternalModel().savedStatus
            }
        )
    }
}

private fun testNewsResource(
    id: Int = 0,
) = CourseEntity(
    id = id,
    title = "",
    successCriteria = SuccessCriteria(numSoldTickets = 10),
    numSoldTickets = 5,
    status = "",
    proposalDueTime = "",
    coverImageUrl = "",
    savedStatus = "",
    coin = 0,
)
