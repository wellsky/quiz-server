package quiz.server.db

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import quiz.server.db.table.AnswersTable
import quiz.server.db.table.QuestionsTable

object DatabaseFactory {
    fun init() {
        val database = Database.connect("jdbc:sqlite:c:\\data\\sqlite\\quiz.db", "org.sqlite.JDBC")

        transaction(database) {
            SchemaUtils.create(QuestionsTable)
            SchemaUtils.create(AnswersTable)
        }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}