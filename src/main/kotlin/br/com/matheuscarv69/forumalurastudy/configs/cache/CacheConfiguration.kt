package br.com.matheuscarv69.forumalurastudy.configs.cache

import br.com.matheuscarv69.forumalurastudy.entities.topic.response.TopicResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.CacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.cache.RedisCacheWriter
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair
import java.time.Duration


@Configuration
class CacheConfiguration(
    private val connectionFactory: RedisConnectionFactory,
    private val objectMapper: ObjectMapper,
    @Value("\${spring.application.name}")
    private val applicationName: String
) {

    @Bean
    fun cacheManager(): CacheManager {
        val redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory)

        val jackson2JsonRedisSerializer = Jackson2JsonRedisSerializer(TopicResponse::class.java).apply {
            this.setObjectMapper(objectMapper)
        }

        val default = RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofSeconds(10))
            .computePrefixWith { name -> "$applicationName:$name:" }
            .serializeValuesWith(SerializationPair.fromSerializer(jackson2JsonRedisSerializer))

        return RedisCacheManager.RedisCacheManagerBuilder.fromCacheWriter(redisCacheWriter)
            .cacheDefaults(default)
            .withCacheConfiguration("topicsList", default)
            .withCacheConfiguration("findTopicById", default)
            .build()
    }
}