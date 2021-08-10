package br.com.matheuscarv69.forumalurastudy.entities.topic.response

import br.com.matheuscarv69.forumalurastudy.entities.user.model.User
import com.fasterxml.jackson.annotation.JsonProperty

data class AuthorResponse(

    @field:JsonProperty
    val name: String,

    @field:JsonProperty
    val email: String
) {
    constructor(author: User) : this(
        name = author.name,
        email = author.email
    )

}
