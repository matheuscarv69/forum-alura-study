package br.com.matheuscarv69.forumalurastudy.entities.topic.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UpdateTopicRequest(
    @field:NotBlank
    @field:Size(min = 5, max = 100)
    val title: String,

    @field:NotBlank
    @field:Size(min = 5, max = 1000)
    val message: String,
) {

}
