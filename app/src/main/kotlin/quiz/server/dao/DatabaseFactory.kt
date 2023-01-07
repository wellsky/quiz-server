package quiz.server.dao

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import quiz.server.model.Questions

object DatabaseFactory {
    fun init() {
        val database = Database.connect("jdbc:sqlite:c:\\data\\sqlite\\quiz.db", "org.sqlite.JDBC")

        transaction(database) {
            SchemaUtils.create(Questions)
        }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}