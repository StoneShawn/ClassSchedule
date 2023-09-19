package shawn.model

import java.io.Serializable

data class Course(
    val name: String,
    val saveStatus: Boolean
): Serializable
