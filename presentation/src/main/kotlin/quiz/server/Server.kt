package quiz.server

import configureSerialization
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import quiz.server.plugins.configureCommonRouting

fun startServer() {
    embeddedServer(Netty, port = 8080, host = "192.168.10.3", module = Application::module)
        .start(wait = true)
}

private fun Application.module() {
    configureSerialization()
    configureCommonRouting()
}
