package br.com.matheuscarv69.forumalurastudy.entities.course.request

import br.com.matheuscarv69.forumalurastudy.entities.course.model.Course
import javax.validation.constraints.NotBlank

data class CourseRequest(

    @field: NotBlank
    val name: String,

    @field: NotBlank
    val category: String,
) {

    fun toModel() = Course(
        name = this.name,
        category = this.category
    )

}
