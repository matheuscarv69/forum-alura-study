package br.com.matheuscarv69.forumalurastudy.entities.course.request

import br.com.matheuscarv69.forumalurastudy.configs.validation.UniqueValue
import br.com.matheuscarv69.forumalurastudy.entities.course.model.Course
import javax.validation.constraints.NotBlank

data class CourseRequest(

    @field: NotBlank
    @field:UniqueValue(
        domainClass = Course::class,
        fieldName = "name",
        message = "This Course's name informed already exists in database, try again with other Name"
    )
    val name: String,

    @field: NotBlank
    val category: String,
) {

    fun toModel() = Course(
        name = this.name,
        category = this.category
    )

}
