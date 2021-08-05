package br.com.matheuscarv69.forumalurastudy.entities.topic.controllers

import br.com.matheuscarv69.forumalurastudy.entities.course.model.Course
import br.com.matheuscarv69.forumalurastudy.entities.topic.model.Answer
import br.com.matheuscarv69.forumalurastudy.entities.topic.model.Topic
import br.com.matheuscarv69.forumalurastudy.entities.topic.response.TopicResponse
import br.com.matheuscarv69.forumalurastudy.entities.user.model.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/topics")
class ToListTopicController {

    @GetMapping
    fun toListTopic(): ResponseEntity<List<TopicResponse>> {
        val answer = Answer(
            id = 1L,
            message = "Because it's implicit in the language",
            author = User(
                id = 1L,
                name = "Rafael Ponte",
                email = "rafa.ponte@puz.com"
            ),
            solution = false
        )

        val topic = Topic(
            id = 1L,
            title = "Getters and Setter in Kotlin",
            message = "Good morning folks, I have a question about getters and setters in kotlin, why we don't declarate these methods?",
            course = Course(
                id = 1L,
                name = "API REST - Kotlin Spring Boot - Web Layer",
                category = "Kotlin Formation",
            ),
            author = User(
                id = 1L,
                name = "Yuri Matheus",
                email = "yuri.matheus@puz.com"
            ),
        )

        answer.topic = topic
        topic.answers.add(answer)
        topic.answers.add(answer)
        topic.answers.add(answer)

        return ResponseEntity.ok(listOf(TopicResponse(topic)))
    }

}