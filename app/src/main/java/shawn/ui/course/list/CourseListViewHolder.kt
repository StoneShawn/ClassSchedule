package shawn.ui.course.list

import android.content.Context
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.shawn.model.Course
import `in`.hahow.android_recruit_project.R
import `in`.hahow.android_recruit_project.databinding.ItemCourseListBinding
import okhttp3.OkHttpClient
import shawn.ui.course.CourseStatusEnum
import shawn.util.GlideApp
import shawn.util.UiUtils

class CourseListViewHolder(private val binding: ItemCourseListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setData(data: Course) {
        val context: Context = binding.root.context
        binding.apply {
            tvTitle.text = data.title
            tvGoal.text = "${data.getSoldPercent()}%"
            tvTime.text = "倒數三天"
            tvCoin.text = "好幣 2,000 MP"
            tvStatus.text = context.getString(CourseStatusEnum.valueOf(data.status).text)
            tvStatus.background.setTint(ContextCompat.getColor(context,CourseStatusEnum.valueOf(data.status).color))
            progressBar.progress = data.getSoldPercent()

            loadCoverImage(
                binding.ivCover,
                data.coverImageUrl, ""
            )
        }
//        binding.tvTitle.text = data.title
//        binding.tvGoal.text = "${data.getSoldPercent()}%"
//        binding.tvTime.text = "倒數三天"
//        binding.tvCoin.text = "好幣 2,000 MP"
//        binding.tvStatus.text = context.getString(CourseStatusEnum.valueOf(data.status).text)
//        binding.progressBar.progress = data.getSoldPercent()


    }

    private fun loadCoverImage(view: ImageView?, imgUrl: String, imgFileName: String?) {
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