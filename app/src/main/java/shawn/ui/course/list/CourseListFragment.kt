package shawn.ui.course.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import `in`.hahow.android_recruit_project.databinding.FragmentCourseListBinding
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import shawn.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CourseListFragment() : BaseFragment() {

    private val viewModel: CourseListViewModel by viewModel()

    private lateinit var binding: FragmentCourseListBinding
    private val classScheduleListAdapter: CourseListAdapter by lazy {
        CourseListAdapter()
    }

    companion object {
        fun newInstance(): CourseListFragment {
            return CourseListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCourseListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var courseListUiState: CourseListViewModel.CourseListUiState by mutableMapOf()

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.courseListUiState
                    .onEach {
                        courseListUiState = it
                    }
                    .collect()
            }
        }
        initView()
    }

    private fun initView(){
        binding.recyclerview.adapter = classScheduleListAdapter
        val list = arrayListOf<ClassSchedule>()
        list.add(ClassSchedule("123","123"))
        classScheduleListAdapter.submitList(list)
    }

}