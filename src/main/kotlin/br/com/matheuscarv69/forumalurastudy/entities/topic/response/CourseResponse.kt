package br.com.matheuscarv69.forumalurastudy.entities.topic.response

import br.com.matheuscarv69.forumalurastudy.entities.course.model.Course
import java.io.Serializable

data class CourseResponse(
    val name: String,
    val category: String
): Serializable {

    constructor(course: Course) : this(
        name = course.name,
        category = course.category
    )

}
