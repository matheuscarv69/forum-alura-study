package br.com.matheuscarv69.forumalurastudy.configs.cache

import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.CacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.cache.RedisCacheWriter
import org.springframework.data.redis.connection.RedisConnectionFactory
import java.time.Duration

@Configuration
class CacheConfiguration(
    private val connectionFactory: RedisConnectionFactory,
    @Value("\${spring.application.name}")
    private val applicationName: String
) {

    @Bean
    fun cacheManager(): CacheManager {
        val redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory)

//        Isolate configuration for a unique topic
//        val cacheFindAllTopicsConfig = RedisCacheConfiguration.defaultCacheConfig()
//            .entryTtl(Duration.ofSeconds(10)) // specific ttl for cache findTopicAll
//            .serializeValuesWith(SerializationPair.fromSerializer(GenericJackson2JsonRedisSerializer()))

        return RedisCacheManager.RedisCacheManagerBuilder.fromCacheWriter(redisCacheWriter)
            .cacheDefaults(
                RedisCacheConfiguration.defaultCacheConfig()
                    .computePrefixWith { name -> "$applicationName:$name:" } // add application name's with key in cache at redis
                    .entryTtl(Duration.ofSeconds(10))
            )
            .build()
    }
}