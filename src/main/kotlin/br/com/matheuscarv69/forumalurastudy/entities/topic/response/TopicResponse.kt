package br.com.matheuscarv69.forumalurastudy.entities.topic.response

import br.com.matheuscarv69.forumalurastudy.entities.topic.model.Topic
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.boot.jackson.JsonComponent
import org.springframework.cache.annotation.Cacheable
import java.time.LocalDateTime

data class TopicResponse(

    @field:JsonProperty
    val title: String?,
    @field:JsonProperty
    val message: String?,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", shape = JsonFormat.Shape.STRING)
    @field:JsonProperty
    val createdAt: LocalDateTime?,
    @field:JsonProperty
    val course: CourseResponse?,
    @field:JsonProperty
    val author: AuthorResponse?,
    @field:JsonProperty
    val status: String?,
    @field:JsonProperty
    val answer: List<AnswerResponse>? = ArrayList()
) {

    constructor(topic: Topic) : this(
        topic.title,
        topic.message,
        topic.createdAt,
        CourseResponse(topic.course),
        AuthorResponse(topic.author),
        status = topic.status.name,
        answer = topic.answers.map { answer ->
            AnswerResponse(answer)
        }

    )

}