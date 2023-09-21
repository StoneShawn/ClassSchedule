package com.shawn.data.model

import com.shawn.database.model.CourseEntity
import com.shawn.network.model.NetworkCourse

fun NetworkCourse.asEntity() = CourseEntity(
    id = id,
    successCriteria = successCriteria,
    numSoldTickets = numSoldTickets,
    status = status,
    proposalDueTime = proposalDueTime,
    coverImageUrl = coverImageUrl,
    title = title,
    savedStatus = savedStatus,
    coin = coin
)