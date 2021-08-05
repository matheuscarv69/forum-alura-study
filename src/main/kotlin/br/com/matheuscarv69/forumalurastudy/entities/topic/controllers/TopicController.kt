package br.com.matheuscarv69.forumalurastudy.entities.topic.controllers

import br.com.matheuscarv69.forumalurastudy.entities.course.model.Course
import br.com.matheuscarv69.forumalurastudy.entities.topic.model.Topic
import br.com.matheuscarv69.forumalurastudy.entities.topic.request.TopicRequest
import br.com.matheuscarv69.forumalurastudy.entities.topic.response.TopicResponse
import br.com.matheuscarv69.forumalurastudy.entities.user.model.User
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/api/topics")
class TopicController(private var topicsList: MutableList<Topic> = ArrayList()) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    companion object {
        var ID: Long = 1L

        val COURSE = Course(
            id = 1L,
            name = "API REST - Kotlin Spring Boot - Web Layer",
            category = "Kotlin Formation",
        )

        val AUTHOR = User(
            id = 1L,
            name = "Yuri Matheus",
            email = "yuri.matheus@puz.com"
        )
    }

    @GetMapping
    fun toListTopic(): ResponseEntity<List<TopicResponse>> {
        val listOfTopics = topicsList.map { topic -> TopicResponse(topic) }

        return ResponseEntity.ok(listOfTopics)
    }

    @GetMapping("/{id}")
    fun findTopicById(@PathVariable("id") id: Long): ResponseEntity<TopicResponse> {

        topicsList.forEach { topic ->
            if (topic.id == id) {
                logger.info("This topic Id: $id found")
                return ResponseEntity.ok(TopicResponse(topic))
            }
        }

        logger.info("This topic Id: $id not found")
        return ResponseEntity.notFound().build()

    }

    @PostMapping
    fun createTopic(
        @RequestBody @Valid request: TopicRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<Any> {

        if ((request.courseId == COURSE.id) && (request.userId == AUTHOR.id)) {
            val topic = request.toModel(course = COURSE, author = AUTHOR)

            topic.id = ID++
            topicsList.add(topic)

            logger.info("Salving Topic: ${topic.id}, title: ${topic.title}")

            val uri: URI = uriBuilder.path("/api/topics/{topicId}").buildAndExpand(topic.id).toUri()

            return ResponseEntity.created(uri).build()
        }

        return ResponseEntity.badRequest().body("This course Id or author Id are incorrect")
    }

}