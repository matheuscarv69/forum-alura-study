package br.com.matheuscarv69.forumalurastudy.entities.topic.controllers

import br.com.matheuscarv69.forumalurastudy.entities.topic.request.TopicRequest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ActiveProfiles
import java.net.URI

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
internal class CreateTopicControllerTest(
    @Autowired
    val client: TestRestTemplate
) {

    @LocalServerPort
    lateinit var randomServerPort: String


    /**
     * 1. happy path - create topic - ok
     * 2. Don't create topic
     * 3.
     * */


    @Test
    fun `Should create topic`() {
        // scenery
        val uri = URI("http://localhost:$randomServerPort/api/topics")
        val request = TopicRequest(
            title = "How the scope functions it works?",
            message = "How do let and apply work?",
            courseId = 1L,
            authorId = 1L
        )

        // actions
        val response = client.postForEntity(
            uri,
            request,
            ResponseEntity::class.java
        )

        // validations
        with(response) {
            assertNotNull(response)
            assertEquals(HttpStatus.CREATED.value(), response.statusCode.value())
        }

    }

}