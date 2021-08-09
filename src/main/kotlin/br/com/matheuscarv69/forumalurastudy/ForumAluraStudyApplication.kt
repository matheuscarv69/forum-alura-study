package br.com.matheuscarv69.forumalurastudy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class ForumAluraStudyApplication

fun main(args: Array<String>) {
    runApplication<ForumAluraStudyApplication>(*args)
}
