package br.com.matheuscarv69.forumalurastudy.entities.topic.controllers

import br.com.matheuscarv69.forumalurastudy.configs.exception.TopicNotFoundException
import br.com.matheuscarv69.forumalurastudy.entities.course.model.Course
import br.com.matheuscarv69.forumalurastudy.entities.topic.model.Topic
import br.com.matheuscarv69.forumalurastudy.entities.topic.request.TopicRequest
import br.com.matheuscarv69.forumalurastudy.entities.topic.request.UpdateTopicRequest
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

    @PutMapping("/{id}")
    fun updateTopic(@PathVariable id: Long, @RequestBody @Valid request: UpdateTopicRequest): ResponseEntity<Any> {

        topicsList.stream().filter { topic ->
            topic.id == id
        }.findFirst().orElseThrow {
            logger.info("This topic Id: $id not found")
            TopicNotFoundException("This Topic ID: $id not found")
        }.let { topicExists ->
            logger.info("Topic id: $id found and update for Topic title: ${request.title}, message: ${request.message}")
            topicExists.title = request.title
            topicExists.message = request.message
            return ResponseEntity.ok().build()
        }

    }

    @DeleteMapping("/{id}")
    fun deleteTopic(@PathVariable id: Long): ResponseEntity<Any> {

        topicsList.stream().filter { topic ->
            topic.id == id
        }.findFirst().orElseThrow {
            logger.warn("Topic id: $id not found for to delete")
            TopicNotFoundException("This Topic ID: $id not found")
        }.let { topicExists ->
            logger.info("Topic id: $id found and deleted")
            topicsList.remove(topicExists)
            return ResponseEntity.noContent().build()
        }

    }

}
