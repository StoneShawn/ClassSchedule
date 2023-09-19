package com.shawn.model

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

data class SuccessCriteria(
    val numSoldTickets: Int
)