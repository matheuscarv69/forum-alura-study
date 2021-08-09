package br.com.matheuscarv69.forumalurastudy.entities.topic.controllers

import br.com.matheuscarv69.forumalurastudy.configs.exception.TopicNotFoundException
import br.com.matheuscarv69.forumalurastudy.entities.topic.repository.TopicRepository
import br.com.matheuscarv69.forumalurastudy.entities.topic.request.UpdateTopicRequest
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional

@RestController
@RequestMapping("/api/topics")
class UpdateTopicController(
    private val topicRepository: TopicRepository
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @PutMapping("/{topicId}")
    @Transactional
    fun updateTopic(
        @PathVariable topicId: Long,
        @RequestBody request: UpdateTopicRequest
    ): ResponseEntity<Any> {

        topicRepository.findById(topicId).orElseThrow {
            TopicNotFoundException("This Topic ID: $topicId not found")
        }.let { topic ->
            logger.info("Topic id: $topicId found and update for Topic title: ${request.title}, message: ${request.message}")
            topic.title = request.title
            topic.message = request.message

            topicRepository.save(topic)
            return ResponseEntity.ok().build()
        }

    }

}