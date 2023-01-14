package quiz.server.model

import kotlinx.serialization.Serializable

@Serializable
data class Question (
    val id: Long,
    val text: String,
)
