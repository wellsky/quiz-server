package quiz.server.plugins

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject
import quiz.server.model.AnswerAttemptRequest
import quiz.server.model.AnswerAttemptResponse
import quiz.server.repository.QuizRepository

fun Application.configureCommonRouting() {
    val repository:  QuizRepository by inject()

    routing {
        get("/test") {
            call.respond(mapOf("hello" to "world"))
        }

        get("/randomquestion") {
            val questionWithAnswers = repository.getRandomQuestion()

            if (questionWithAnswers != null) {
                call.respond(questionWithAnswers)
            } else {
                call.respond(HttpStatusCode.NotFound)
            }
        }

        post("/answer") {
            val answerAttemptRequest = call.receive<AnswerAttemptRequest>()

            call.respond(AnswerAttemptResponse(
                questionId = answerAttemptRequest.questionId,
                answerId = answerAttemptRequest.answerId,
                correct = false,
            ))
        }

//        get("/question/{id}") {
//            val id = call.parameters.getOrFail("id").toLong()
//            val question = questionDao.question(id)
//
//            if (question != null) {
//                val answers = answerDao.questionAnswers(question.id)
//
//                val questionWithAnswers = QuestionWithAnswers(
//                    id = question.id,
//                    text = question.text,
//                    answers = answers,
//                )
//
//                call.respond(questionWithAnswers)
//            } else {
//                call.respond(HttpStatusCode.NotFound)
//            }
//        }
//
//        get("/question/{id}/answers") {
//            val id = call.parameters.getOrFail("id").toLong()
//            val answers = answerDao.questionAnswers(id)
//
//            if (answers.isNotEmpty()) {
//                call.respond(answers)
//            } else {
//                call.respond(HttpStatusCode.NotFound)
//            }
//        }
    }
}