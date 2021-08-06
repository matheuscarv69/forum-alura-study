package br.com.matheuscarv69.forumalurastudy.entities.topic.model

import br.com.matheuscarv69.forumalurastudy.entities.course.model.Course
import br.com.matheuscarv69.forumalurastudy.entities.user.model.User
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.FutureOrPresent
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Topic(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @field:NotBlank
    @field:Size(min = 5, max = 100)
    @Column(nullable = false)
    var title: String,

    @field:NotBlank
    @field:Size(min = 5, max = 1000)
    @Column(nullable = false)
    var message: String,

    @field:FutureOrPresent
    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val course: Course,

    @ManyToOne
    val author: User,

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    val status: StatusTopic = StatusTopic.NOT_ANSWERED,

    @OneToMany(mappedBy = "topic")
    val answers: MutableList<Answer> = ArrayList()
)