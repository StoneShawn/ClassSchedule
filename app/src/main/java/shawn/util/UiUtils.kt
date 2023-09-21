package shawn.util

import android.content.res.Resources
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object UiUtils {

    fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density).toInt()
    }


    // DateFormat
    fun getDaysLeft(dateTimeString: String): Long {
        val formatter = DateTimeFormatter.ISO_DATE_TIME
        val proposalDueTime = LocalDateTime.parse(dateTimeString, formatter).toLocalDate()
        val now = LocalDate.now(ZoneId.of("Asia/Taipei"))
        return proposalDueTime.toEpochDay() - now.toEpochDay()
    }
}