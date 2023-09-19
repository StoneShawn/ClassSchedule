package shawn.ui.course.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.hahow.android_recruit_project.databinding.FragmentCourseListBinding
import shawn.base.BaseFragment

class CourseListFragment : BaseFragment() {

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

        initView()
    }

    private fun initView(){
        binding.recyclerview.adapter = classScheduleListAdapter
        val list = arrayListOf<ClassSchedule>()
        list.add(ClassSchedule("123","123"))
        classScheduleListAdapter.submitList(list)
    }

}