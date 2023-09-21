package com.shawn.model

import kotlinx.serialization.Serializable

data class Course(
    val id: Int,
    val successCriteria: SuccessCriteria,
    val numSoldTickets: Int,
    val status: String,
    val proposalDueTime: String,
    val coverImageUrl: String,
    val title: String,
    val savedStatus: String,
    val coin: Int
) {
    fun getSoldPercent() = successCriteria.numSoldTickets.takeIf { it != 0 }.let {
        ((numSoldTickets
            .toDouble() / successCriteria.numSoldTickets.toDouble()) * 100).toInt()
    } ?: 0

}

enum class Status{
    INCUBATING,PUBLISHED, SUCCESS
}


@Serializable
data class SuccessCriteria(
    val numSoldTickets: Int
)