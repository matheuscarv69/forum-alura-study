package br.com.matheuscarv69.forumalurastudy.entities.topic.model

import br.com.matheuscarv69.forumalurastudy.entities.course.model.Course
import br.com.matheuscarv69.forumalurastudy.entities.user.model.User
import java.time.LocalDateTime

class Topic(
    var id: Long? = null,
    var title: String,
    var message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,
    val answers: MutableList<Answer> = ArrayList()
)