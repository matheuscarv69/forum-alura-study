package br.com.matheuscarv69.forumalurastudy.entities.topic.controllers

import br.com.matheuscarv69.forumalurastudy.entities.topic.repository.TopicRepository
import br.com.matheuscarv69.forumalurastudy.entities.topic.response.TopicResponse
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort.Direction.ASC
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/topics")
class FindAllTopicsController(
    private val topicRepository: TopicRepository
) {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping
    @Cacheable(value = ["topicsList"])
    fun findAllTopics(
        @RequestParam(required = false) courseName: String?,
        @PageableDefault(
            page = 0,
            size = 10,
            sort = ["createdAt"],
            direction = ASC
        ) pageable: Pageable
    ): Page<TopicResponse> {

        if (courseName == null) {
            logger.info("Get all topics")
            return topicRepository
                .findAll(pageable)
                .map { topic ->
                    TopicResponse(topic)
                }
        }

        return topicRepository
            .findByCourseName(courseName, pageable)
            .map { topic ->
                TopicResponse(topic)
            }
    }

}