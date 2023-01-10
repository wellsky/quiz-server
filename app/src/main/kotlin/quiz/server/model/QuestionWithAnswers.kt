package quiz.server.model

import kotlinx.serialization.Serializable

@Serializable
data class QuestionWithAnswers (
    val id: Long,
    val text: String,
    val answers: List<Answer>,
)
