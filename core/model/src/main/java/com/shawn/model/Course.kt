package com.shawn.model

import kotlinx.serialization.Serializable

data class Course(
    val successCriteria : SuccessCriteria,
    val numSoldTickets: Int,
    val status: String,
    val proposalDueTime: String,
    val coverImageUrl: String,
    val title: String,
    val savedStatus: String,
    val coin : Int
)


@Serializable
data class SuccessCriteria(
    val numSoldTickets: Int
)