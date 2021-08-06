package br.com.matheuscarv69.forumalurastudy.entities.course.controllers

import br.com.matheuscarv69.forumalurastudy.entities.course.repository.CourseRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/courses")
class CreateCourseController(private val courseRepository: CourseRepository) {

    @PostMapping
    fun createCourse() {

    }

}