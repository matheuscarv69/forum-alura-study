package br.com.matheuscarv69.forumalurastudy.entities.course.repository

import br.com.matheuscarv69.forumalurastudy.entities.course.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Long>