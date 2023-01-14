package db.repository

import db.dao.AnswerDAO
import db.dao.QuestionDAO
import quiz.server.model.QuestionWithAnswers
import quiz.server.repository.QuizRepository

class QuizRepositoryImpl(
    private val questionDao: QuestionDAO,
    private val answerDao: AnswerDAO,
) : QuizRepository {

    override suspend fun getRandomQuestion(): QuestionWithAnswers? {
        val question = questionDao.randomQuestion()

        if (question != null) {
            val answers = answerDao.questionAnswers(question.id)

            return QuestionWithAnswers(
                id = question.id,
                text = question.text,
                answers = answers,
            )
        }

        return null
    }
}