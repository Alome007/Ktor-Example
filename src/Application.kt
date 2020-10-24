package com.hello_world

import io.ktor.application.*
import io.ktor.http.ContentType
import io.ktor.request.receive
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)
private val users="{\"users\":note[\"Daniel\",\"John\",\"David\"]}"
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing{
        get("/"){
            call.respondText("Hello World", ContentType.Text.Plain)
        }

        post("/"){
            val postData=call.receive<String>()
            call.respondText("I have received $postData", ContentType.Text.Plain)
        }

        // /users
        get("/users"){
            call.respondText { users }
        }
    }
}

