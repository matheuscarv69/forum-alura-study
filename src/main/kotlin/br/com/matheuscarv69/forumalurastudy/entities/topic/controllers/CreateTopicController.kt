package br.com.matheuscarv69.forumalurastudy.entities.topic.controllers

import br.com.matheuscarv69.forumalurastudy.configs.exception.AuthorNotFoundException
import br.com.matheuscarv69.forumalurastudy.configs.exception.CourseNotFoundException
import br.com.matheuscarv69.forumalurastudy.entities.course.repository.CourseRepository
import br.com.matheuscarv69.forumalurastudy.entities.topic.repository.TopicRepository
import br.com.matheuscarv69.forumalurastudy.entities.topic.request.TopicRequest
import br.com.matheuscarv69.forumalurastudy.entities.user.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import javax.validation.Valid


@RestController
@RequestMapping("/api/topics")
class CreateTopicController(
    private val topicRepository: TopicRepository,
    private val courseRepository: CourseRepository,
    private val userRepository: UserRepository
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun createTopic(@RequestBody @Valid request: TopicRequest, uriBuilder: UriComponentsBuilder): ResponseEntity<Any> {

        val course = courseRepository.findById(request.courseId).orElseThrow {
            CourseNotFoundException("This Course ID: ${request.courseId} not found")
        }

        val author = userRepository.findById(request.authorId).orElseThrow {
            AuthorNotFoundException("This Author ID: ${request.authorId} not found")
        }

        request.toModel(course, author).let { topic ->
            logger.info("Salving Topic: ${topic.id}, title: ${topic.title}")

            topicRepository.save(topic)

            val uri: URI = uriBuilder.path("/api/topics/{topicId}").buildAndExpand(topic.id).toUri()
            return ResponseEntity.created(uri).build()
        }

    }

}