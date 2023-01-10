package quiz.server.db.table

import org.jetbrains.exposed.sql.Table

object QuestionsTable : Table() {
    val id = long("id").autoIncrement()
    val text = varchar("text", 256)

    override val primaryKey = PrimaryKey(id)
}