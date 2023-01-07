package quiz.server.dao

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import quiz.server.dao.DatabaseFactory.dbQuery
import quiz.server.model.Question
import quiz.server.model.Questions

class QuestionDAOImpl : QuestionDAO {
    override suspend fun question(id: Long): Question? = dbQuery {
        Questions
            .select { Questions.id eq id }
            .map(::resultRowToQuestion)
            .singleOrNull()
    }

    private fun resultRowToQuestion(row: ResultRow) = Question(
        id = row[Questions.id],
        text = row[Questions.text],
    )
}