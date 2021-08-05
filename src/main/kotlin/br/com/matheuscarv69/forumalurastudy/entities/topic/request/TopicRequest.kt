package br.com.matheuscarv69.forumalurastudy.entities.topic.request

import br.com.matheuscarv69.forumalurastudy.entities.course.model.Course
import br.com.matheuscarv69.forumalurastudy.entities.topic.model.Topic
import br.com.matheuscarv69.forumalurastudy.entities.user.model.User
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive
import javax.validation.constraints.Size


data class TopicRequest(

    @field:NotBlank
    @field:Size(min = 5, max = 100)
    val title: String,

    @field:NotBlank
    @field:Size(min = 5, max = 1000)
    val message: String,

    @field:NotNull
    @field:Positive
    val courseId: Long,

    @field:NotNull
    @field:Positive
    val userId: Long,

    ) {

    fun toModel(course: Course, author: User) = Topic(
        title = this.title,
        message = this.message,
        course = course,
        author = author
    )
}