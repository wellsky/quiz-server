package quiz.server.db.table

import org.jetbrains.exposed.sql.Table

object AnswersTable: Table() {
    val id = long("id").autoIncrement()
    val questionId = long("question_id")
    val text = varchar("text", 256)

    override val primaryKey = PrimaryKey(id)
}