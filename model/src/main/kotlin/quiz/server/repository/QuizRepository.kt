package quiz.server.repository

import quiz.server.model.QuestionWithAnswers

interface QuizRepository {
    suspend fun getRandomQuestion(): QuestionWithAnswers?
}