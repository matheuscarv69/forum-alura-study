package br.com.matheuscarv69.forumalurastudy.entities.user.controllers

import br.com.matheuscarv69.forumalurastudy.entities.user.repository.UserRepository
import br.com.matheuscarv69.forumalurastudy.entities.user.request.UserRequest
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/api/users")
class CreateUserController(private val userRepository: UserRepository) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun createUser(@RequestBody @Valid request: UserRequest, uriBuilder: UriComponentsBuilder): ResponseEntity<Any> {

        request.toModel().let { user ->
            logger.info("Save user: ${user.name}")
            userRepository.save(user)

            val uri: URI = uriBuilder.path("/api/users/{userId}").buildAndExpand(user.id).toUri()
            return ResponseEntity.created(uri).build()
        }
    }

}