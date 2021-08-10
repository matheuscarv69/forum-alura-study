package br.com.matheuscarv69.forumalurastudy.entities.topic.controllers

import br.com.matheuscarv69.forumalurastudy.configs.exception.TopicNotFoundException
import br.com.matheuscarv69.forumalurastudy.entities.topic.repository.TopicRepository
import br.com.matheuscarv69.forumalurastudy.entities.topic.response.TopicResponse
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/topics")
class FindTopicByIdController(
    private val topicRepository: TopicRepository
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/{topicId}")
    @Cacheable(value = ["findTopicById"])
    fun findTopicById(@PathVariable topicId: Long): TopicResponse {

        val possibleTopic = topicRepository.findById(topicId).orElseThrow {
            logger.info("This topic Id: $topicId not found")
            TopicNotFoundException("This Topic ID: $topicId not found")
        }

        logger.info("This topic Id: $topicId found")
//        return ResponseEntity.ok(TopicResponse(possibleTopic))
        return TopicResponse(possibleTopic)
    }


}