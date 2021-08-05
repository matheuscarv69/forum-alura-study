package br.com.matheuscarv69.forumalurastudy.entities.topic.controllers

import br.com.matheuscarv69.forumalurastudy.entities.course.model.Course
import br.com.matheuscarv69.forumalurastudy.entities.topic.model.Answer
import br.com.matheuscarv69.forumalurastudy.entities.topic.model.Topic
import br.com.matheuscarv69.forumalurastudy.entities.topic.response.TopicResponse
import br.com.matheuscarv69.forumalurastudy.entities.user.model.User
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/topics")
class ToListTopicController(private var topics: List<Topic>) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    init {
        val topic1 = createTopic(1L)
        val topic2 = createTopic(2L)
        val topic3 = createTopic(3L)

        topics = listOf(topic1, topic2, topic3)
    }

    @GetMapping
    fun toListTopic(): ResponseEntity<List<TopicResponse>> {
        val listOfTopics = topics.map { topic -> TopicResponse(topic) }

        return ResponseEntity.ok(listOfTopics)
    }

    @GetMapping("/{id}")
    fun findTopicById(@PathVariable("id") id: Long): ResponseEntity<TopicResponse> {

        topics.forEach { topic ->
            if (topic.id == id) {
                logger.info("This topic Id: $id found")
                return ResponseEntity.ok(TopicResponse(topic))
            }
        }

        logger.info("This topic Id: $id not found")
        return ResponseEntity.notFound().build()

    }


    private fun createTopic(id: Long = 1L): Topic {
        val answer = Answer(
            id = id,
            message = "Because it's implicit in the language",
            author = User(
                id = id,
                name = "Rafael Ponte",
                email = "rafa.ponte@puz.com"
            ),
            solution = false
        )

        val topic = Topic(
            id = id,
            title = "Getters and Setter in Kotlin",
            message = "Good morning folks, I have a question about getters and setters in kotlin, why we don't declarate these methods?",
            course = Course(
                id = 1L,
                name = "API REST - Kotlin Spring Boot - Web Layer",
                category = "Kotlin Formation",
            ),
            author = User(
                id = id,
                name = "Yuri Matheus",
                email = "yuri.matheus@puz.com"
            ),
        )
        topic.answers.add(answer)
        topic.answers.add(answer)
        topic.answers.add(answer)

        answer.topic = topic
        return topic
    }

}