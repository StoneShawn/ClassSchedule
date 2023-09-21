package com.shawn.network.model

import com.shawn.model.SuccessCriteria
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCourse(
    val id: Int,
    val successCriteria : SuccessCriteria,
    val numSoldTickets: Int,
    val status: String,
    val proposalDueTime: String="",
    val coverImageUrl: String,
    val title: String,
    val savedStatus: String="",
    val coin : Int=0
)

//@Serializable
//data class NetworkSuccessCriteria(
//    val numSoldTickets: Int
//)