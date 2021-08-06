package br.com.matheuscarv69.forumalurastudy.entities.user.repository

import br.com.matheuscarv69.forumalurastudy.entities.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>