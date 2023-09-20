package shawn.ui.course.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shawn.data.repository.CourseRepository
import com.shawn.model.Course
import com.shawn.network.base.Result
import com.shawn.network.base.asResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class CourseListViewModel(courseRepository: CourseRepository) : ViewModel() {


    val courseListUiState: StateFlow<CourseListUiState> =
        courseUiStateStream(courseRepository).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = CourseListUiState.Loading
        )


    private fun courseUiStateStream(
        courseRepository: CourseRepository
    ): Flow<CourseListUiState> {
        val courseListStream: Flow<List<com.shawn.model.Course>> =
            courseRepository.getCourseStream()

        return courseListStream.asResult().map {
            when (it) {
                is Result.Success -> {
                    CourseListUiState.Success(it.data)
                }

                is Result.Loading -> {
                    CourseListUiState.Loading
                }

                is Result.Error -> {
                    CourseListUiState.Error
                }
            }
        }
    }

    sealed interface CourseListUiState {
        object Error : CourseListUiState
        object Loading : CourseListUiState
        data class Success(val courseData: List<Course>) : CourseListUiState
    }

}