package shawn.ui.class_schedule.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.hahow.android_recruit_project.databinding.FragmentClassScheduleListBinding
import shawn.base.BaseFragment

class ClassScheduleListFragment : BaseFragment() {

    private lateinit var binding: FragmentClassScheduleListBinding
    companion object {
        fun newInstance(): ClassScheduleListFragment {
            return ClassScheduleListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClassScheduleListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView(){

    }

}