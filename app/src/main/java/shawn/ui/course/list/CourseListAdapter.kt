package shawn.ui.course.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.shawn.model.Course
import `in`.hahow.android_recruit_project.databinding.ItemCourseListBinding

class CourseListAdapter(val listener: OnClickListener?) : ListAdapter<Course, CourseListViewHolder>(
    DiffCallBack()
) {

    interface OnClickListener {
        fun onSaveClick(id: Int, saved: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseListViewHolder {
        return CourseListViewHolder(
            ItemCourseListBinding.inflate(
                LayoutInflater
                    .from(parent.context), parent, false
            ), saveListener = { id, saved -> listener?.onSaveClick(id, saved) }
        )
    }

    override fun onBindViewHolder(holder: CourseListViewHolder, position: Int) {
        currentList[position]?.let {
            holder.setData(it)
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<Course>() {
        override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
            return oldItem.id == newItem.id
        }
    }
}