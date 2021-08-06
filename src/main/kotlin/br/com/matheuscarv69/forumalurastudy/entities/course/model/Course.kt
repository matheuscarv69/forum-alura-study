package br.com.matheuscarv69.forumalurastudy.entities.course.model

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Course(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @field:NotBlank
    @field:Size(max = 100)
    @Column(nullable = false, unique = true)
    val name: String,

    @field:NotBlank
    @Column(nullable = false)
    val category: String
)
