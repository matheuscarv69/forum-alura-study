package br.com.matheuscarv69.forumalurastudy.entities.topic.response

import br.com.matheuscarv69.forumalurastudy.entities.course.model.Course

data class CourseResponse(
    val name: String,
    val category: String
) {

    constructor(course: Course) : this(
        name = course.name,
        category = course.category
    )

}
