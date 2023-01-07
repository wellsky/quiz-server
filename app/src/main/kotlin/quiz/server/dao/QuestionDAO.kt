package quiz.server.dao

import quiz.server.model.Question

interface QuestionDAO {
    suspend fun question(id: Long): Question?
}