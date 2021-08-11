package br.com.matheuscarv69.forumalurastudy.entities.topic.response

import br.com.matheuscarv69.forumalurastudy.entities.user.model.User
import java.io.Serializable

data class AuthorResponse(
    val name: String,
    val email: String
) : Serializable {
    constructor(author: User) : this(
        name = author.name,
        email = author.email
    )

}
