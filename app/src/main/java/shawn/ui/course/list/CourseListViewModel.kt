package shawn.ui.course.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.Course
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import shawn.data.remote.GetCourseRepository

class CourseListViewModel(private val repository: GetCourseRepository) : ViewModel() {


    sealed interface CourseUiState{
        object Loading: CourseUiState
        data class Success(val courseData: Course): CourseUiState
    }
    init {
        viewModelScope.launch {
        }
    }
}