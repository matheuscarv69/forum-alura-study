package br.com.matheuscarv69.forumalurastudy.entities.topic.model

import br.com.matheuscarv69.forumalurastudy.entities.user.model.User
import java.time.LocalDateTime

class Answer(
    val id: Long? = null,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val author: User,
    var topic: Topic? = null,
    val solution: Boolean
)