package br.com.matheuscarv69.forumalurastudy.entities.user.request

import br.com.matheuscarv69.forumalurastudy.entities.user.model.User
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class UserRequest(

    @field:NotBlank
    val name: String,

    @field:NotBlank
    @field:Email
    val email: String
) {

    fun toModel() = User(
        name = this.name,
        email = this.email
    )

}
