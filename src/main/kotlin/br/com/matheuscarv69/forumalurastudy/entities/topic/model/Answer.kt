package br.com.matheuscarv69.forumalurastudy.entities.topic.model

import br.com.matheuscarv69.forumalurastudy.entities.user.model.User
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Answer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    @field:Size(min = 5, max = 2000)
    @Column(nullable = false)
    val message: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val author: User,

    @ManyToOne
    var topic: Topic? = null,

    @Column(nullable = false)
    val solution: Boolean = false
)