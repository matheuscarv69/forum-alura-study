package br.com.matheuscarv69.forumalurastudy.entities.topic.controllers

import br.com.matheuscarv69.forumalurastudy.entities.topic.repository.TopicRepository
import br.com.matheuscarv69.forumalurastudy.entities.topic.response.TopicResponse
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort.Direction.ASC
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/topics")
class FindAllTopicsController(
    private val topicRepository: TopicRepository
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping
    fun findAllTopics(
        @PageableDefault(
            page = 0,
            size = 10,
            sort = ["id"],
            direction = ASC
        ) pageable: Pageable
    ): Page<TopicResponse> {

        val topicList = topicRepository.findAll(pageable).map { topic ->
            logger.info("Get all topics")
            TopicResponse(topic)
        }

        return topicList
    }

}