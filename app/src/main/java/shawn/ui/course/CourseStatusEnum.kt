package shawn.ui.course

import `in`.hahow.android_recruit_project.R

enum class CourseStatusEnum(val text: Int, val color: Int) {
    INCUBATING(R.string.course_status_incubation,R.color.orange_f1b470),
    PUBLISHED(R.string.course_status_published,R.color.blue_4cc5b6),
    SUCCESS(R.string.course_status_success,R.color.blue_4cc5b6)
}