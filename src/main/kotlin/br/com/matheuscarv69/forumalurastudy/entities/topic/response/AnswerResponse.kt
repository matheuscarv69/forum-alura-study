package br.com.matheuscarv69.forumalurastudy.entities.topic.response

import br.com.matheuscarv69.forumalurastudy.entities.topic.model.Answer
import java.time.LocalDateTime

data class AnswerResponse(
    val message: String,
    val createdAt: LocalDateTime,
    val author: AuthorResponse,
//    val topic: TopicResponse,
    val topicId: Long,
    val solution: Boolean
) {

    constructor(answer: Answer) : this(
        message = answer.message,
        createdAt = answer.createdAt,
        author = AuthorResponse(answer.author),
//        topic = TopicResponse(answer.topic!!),
        topicId = answer.topic?.id ?: -1,
        solution = answer.solution
    )

}
