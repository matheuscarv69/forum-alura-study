package br.com.matheuscarv69.forumalurastudy.entities.topic.response

import br.com.matheuscarv69.forumalurastudy.entities.topic.model.Answer
import com.fasterxml.jackson.annotation.JsonFormat
import java.io.Serializable
import java.time.LocalDateTime

data class AnswerResponse(
    val message: String,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", shape = JsonFormat.Shape.STRING)
    val createdAt: LocalDateTime,
    val author: AuthorResponse,
    val topicId: Long,
    val solution: Boolean
): Serializable {

    constructor(answer: Answer) : this(
        message = answer.message,
        createdAt = answer.createdAt,
        author = AuthorResponse(answer.author),
//        topic = TopicResponse(answer.topic!!),
        topicId = answer.topic?.id ?: -1,
        solution = answer.solution
    )

}
