package br.com.matheuscarv69.forumalurastudy.entities.topic.response

import br.com.matheuscarv69.forumalurastudy.entities.user.model.User

data class AuthorResponse(
    val name: String,
    val email: String
) {
    constructor(author: User) : this(
        name = author.name,
        email = author.email
    )

}
