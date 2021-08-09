package br.com.matheuscarv69.forumalurastudy.entities.topic.controllers

import br.com.matheuscarv69.forumalurastudy.configs.exception.TopicNotFoundException
import br.com.matheuscarv69.forumalurastudy.entities.topic.repository.TopicRepository
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.transaction.Transactional

@RestController
@RequestMapping("/api/topics")
class DeleteTopicController(
    private val topicRepository: TopicRepository
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @DeleteMapping("/{topicId}")
    @Transactional
    fun deleteTopic(@PathVariable topicId: Long): ResponseEntity<Any> {

        topicRepository.findById(topicId).orElseThrow {
            logger.warn("Topic id: $topicId not found for to delete")
            TopicNotFoundException("This Topic ID: $topicId not found")
        }.let { topic ->
            logger.info("Topic id: $topicId found and deleted")
            topicRepository.delete(topic)
            return ResponseEntity.noContent().build()
        }

    }

}