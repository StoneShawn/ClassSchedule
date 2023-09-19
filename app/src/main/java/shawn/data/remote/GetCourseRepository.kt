package shawn.data.remote

import com.example.data.external.data.NetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import shawn.model.Course

class GetCourseRepository(private val api: NetworkDataSource) {

}