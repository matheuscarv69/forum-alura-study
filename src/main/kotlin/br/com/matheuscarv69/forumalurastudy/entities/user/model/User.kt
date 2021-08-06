package br.com.matheuscarv69.forumalurastudy.entities.user.model

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @field:NotBlank
    @field:Size(max = 100)
    @Column(nullable = false)
    val name: String,

    @field:NotBlank
    @field:Email
    @Column(nullable = false, unique = true)
    val email: String
)
