package com.shawn.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shawn.model.Course
import com.shawn.model.SuccessCriteria

@Entity(
    tableName = "course"
)
data class CourseEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "success_criteria")
    val successCriteria: com.shawn.network.model.SuccessCriteria,
    @ColumnInfo(name = "num_sold_tickets")
    val numSoldTickets: Int,
    val status: String,
    @ColumnInfo(name = "proposal_due_time")
    val proposalDueTime: String,
    @ColumnInfo(name = "cover_image_url")
    val coverImageUrl: String,
    val title: String,
    @ColumnInfo(name = "saved_status", defaultValue = "unsave")
    val savedStatus: String,
    val coin: Int
)

fun CourseEntity.asExternalModel() = Course(
    successCriteria = successCriteria,
    numSoldTickets = numSoldTickets,
    status = status,
    proposalDueTime = proposalDueTime,
    coverImageUrl = coverImageUrl,
    title = title,
    savedStatus = savedStatus,
    coin = coin
)