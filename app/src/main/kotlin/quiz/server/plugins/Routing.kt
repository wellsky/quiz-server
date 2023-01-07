package quiz.server.plugins

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import io.ktor.server.util.getOrFail
import quiz.server.dao.QuestionDAO
import quiz.server.dao.QuestionDAOImpl

fun Application.configureCommonRouting() {
    val dao: QuestionDAO = QuestionDAOImpl()

    routing {
        get("/test") {
            call.respond(mapOf("hello" to "world"))
        }

        get("/question/{id}") {
            val id = call.parameters.getOrFail<Long>("id").toLong()
            val question = dao.question(id)

            if (question != null) {
                call.respond(question)
            } else {
                call.respond(HttpStatusCode.NotFound)
            }
        }
    }
}