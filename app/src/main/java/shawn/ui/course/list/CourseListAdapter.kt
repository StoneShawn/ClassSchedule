package shawn.ui.course.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import `in`.hahow.android_recruit_project.databinding.ItemCourseListBinding
import java.io.Serializable

class CourseListAdapter : ListAdapter<ClassSchedule, CourseListViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseListViewHolder {
        return CourseListViewHolder(
            ItemCourseListBinding.inflate(
                LayoutInflater
                    .from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CourseListViewHolder, position: Int) {
        currentList[position]?.let {
            holder.setData(it)
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<ClassSchedule>() {
        override fun areItemsTheSame(oldItem: ClassSchedule, newItem: ClassSchedule): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ClassSchedule, newItem: ClassSchedule): Boolean {
            return oldItem.name == newItem.name
        }

    }
}


data class ClassSchedule(
    val name: String,
    val value: String
) : Serializable