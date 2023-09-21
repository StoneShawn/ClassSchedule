package shawn.ui.course.list

import android.content.Context
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.shawn.model.Course
import `in`.hahow.android_recruit_project.R
import `in`.hahow.android_recruit_project.databinding.ItemCourseListBinding
import shawn.ui.course.CourseStatusEnum
import shawn.util.GlideApp
import shawn.util.UiUtils

class CourseListViewHolder(
    private val binding: ItemCourseListBinding,
    private val saveListener: (
        (id: Int, saved: String) -> Unit)? = null,
) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        const val SAVE = "save"
        const val UNSAVED = "unsaved"
    }

    fun setData(data: Course) {
        val context: Context = binding.root.context

        binding.apply {
            tvTitle.text = data.title
            tvGoal.text = data.getSoldPercent().takeIf { it >= 100 }?.let { "$it%" } ?: "${
                data
                    .numSoldTickets
            }/${data.successCriteria.numSoldTickets}"
            tvTime.apply {

                if (!data.proposalDueTime.isNullOrEmpty()) {
                    UiUtils.getDaysLeft(data.proposalDueTime).takeIf { it > 0 }?.let {
                        this.isVisible = true
                        this.text = "倒數${it}天"
                    }
                }

            }
            tvCoin.text = "好幣 2,000 MP"
            tvStatus.text = context.getString(CourseStatusEnum.valueOf(data.status).text)
            tvStatus.background.setTint(
                ContextCompat.getColor(
                    context,
                    CourseStatusEnum.valueOf(data.status).color
                )
            )
            ivSave.isSelected = data.savedStatus == SAVE
            ivSave.setOnClickListener {
                saveListener?.invoke(data.id, if (data.savedStatus == SAVE) UNSAVED else SAVE)
            }
            progressBar.apply {
                this.progress = data.getSoldPercent()
                if (data.getSoldPercent()>100){
                    this.setIndicatorColor(ContextCompat.getColor(context,R.color.blue_4cc5b6))
                }
            }
            progressBar.progress = data.getSoldPercent()
            loadCoverImage(ivCover, data.coverImageUrl)
        }
    }

    private fun loadCoverImage(view: ImageView?, imgUrl: String) {
        view?.let {
            val context = view.context

            GlideApp.with(context)
                .load(imgUrl)
                .transform(CenterCrop(), RoundedCorners(UiUtils.dpToPx(10)))
                .error(
                    Glide.with(context).load(R.drawable.ic_launcher_background).error(
                        R.drawable
                            .ic_launcher_background
                    )
                )
                .into(view)
        }
    }
}