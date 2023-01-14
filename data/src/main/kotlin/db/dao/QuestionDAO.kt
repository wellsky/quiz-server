package db.dao

import db.DatabaseFactory.dbQuery
import db.table.QuestionsTable
import org.jetbrains.exposed.sql.Random
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import quiz.server.model.Question

class QuestionDAO {
    suspend fun question(id: Long): Question? = dbQuery {
        QuestionsTable
            .select { QuestionsTable.id eq id }
            .singleOrNull()?.toQuestion()
    }

    suspend fun randomQuestion(): Question? = dbQuery {
        QuestionsTable
            .selectAll()
            .orderBy(Random())
            .firstOrNull()?.toQuestion()
    }

    private fun ResultRow.toQuestion() = Question(
        id = this[QuestionsTable.id],
        text = this[QuestionsTable.text],
    )
}