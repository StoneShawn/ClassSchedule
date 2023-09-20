package shawn.ui.course

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import `in`.hahow.android_recruit_project.R
import `in`.hahow.android_recruit_project.databinding.ActivityCourseBinding
import shawn.ui.course.list.CourseListFragment

class ClassScheduleActivity : AppCompatActivity(), ClassScheduleActivityHandler {

    private lateinit var binding: ActivityCourseBinding

    companion object {
        fun start(context: Context?) {
            context?.let {
                val intent = Intent(context, ClassScheduleActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goClassScheduleList()
    }

    override fun goClassScheduleList() {
        supportFragmentManager.commit {
            replace(R.id.frame_layout, CourseListFragment.newInstance())
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }
}