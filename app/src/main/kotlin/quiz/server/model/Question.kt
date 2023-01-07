package quiz.server.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Question (
    val id: Long,
    val text: String,
)

object Questions : Table() {
    val id = long("id").autoIncrement()
    val text = varchar("text", 256)
    override val primaryKey = PrimaryKey(id)
}
