package com.github.titovart.graal.auth.repository

import com.github.titovart.graal.auth.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : CrudRepository<User, Long> {

    fun findByUsername(username: String): User?

    fun findByEmail(email: String): User?
}
