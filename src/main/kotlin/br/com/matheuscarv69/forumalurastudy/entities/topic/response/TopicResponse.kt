package br.com.matheuscarv69.forumalurastudy.entities.topic.response

import br.com.matheuscarv69.forumalurastudy.entities.topic.model.Topic
import com.fasterxml.jackson.annotation.JsonFormat
import java.io.Serializable
import java.time.LocalDateTime

data class TopicResponse(

    val title: String,
    val message: String,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", shape = JsonFormat.Shape.STRING)
    val createdAt: LocalDateTime,
    val course: CourseResponse,
    val author: AuthorResponse,
    val status: String,
    val answer: List<AnswerResponse> = ArrayList()
) : Serializable {

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