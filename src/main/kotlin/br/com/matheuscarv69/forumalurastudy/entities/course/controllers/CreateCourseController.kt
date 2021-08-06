package br.com.matheuscarv69.forumalurastudy.entities.course.controllers

import br.com.matheuscarv69.forumalurastudy.entities.course.repository.CourseRepository
import br.com.matheuscarv69.forumalurastudy.entities.course.request.CourseRequest
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
@RequestMapping("/api/courses")
class CreateCourseController(private val courseRepository: CourseRepository) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun createCourse(
        @RequestBody @Valid request: CourseRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<Any> {

        request.toModel().let { course ->
            logger.info("Save course: ${course.name}")
            courseRepository.save(course)
            val uri: URI = uriBuilder.path("/api/courses/{courseId}").buildAndExpand(course.id).toUri()

            return ResponseEntity.created(uri).build()
        }

    }

}