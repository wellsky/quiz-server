package db.dao

import db.DatabaseFactory.dbQuery
import db.table.AnswersTable
import org.jetbrains.exposed.sql.Random
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import quiz.server.model.Answer

class AnswerDAO {
    suspend fun questionAnswers(questionId: Long, count: Int = 2) : List<Answer> = dbQuery {
        AnswersTable
            .select{ AnswersTable.questionId eq questionId }
            .limit(count)
            .orderBy(Random())
            .map { it.toAnswer() }
    }

    private fun ResultRow.toAnswer() : Answer =
        Answer(
            id = this[AnswersTable.id],
            questionId = this[AnswersTable.questionId],
            text = this[AnswersTable.text]
        )

}