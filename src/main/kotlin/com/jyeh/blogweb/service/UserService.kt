package com.jyeh.blogweb.service

import com.jyeh.blogweb.domain.User
import com.jyeh.blogweb.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(private val userRepository: UserRepository) {
    fun addUser(user: User): Mono<User> = userRepository.save(user)

    fun deleteUser(userId: String): Mono<Void> = userRepository.deleteById(userId)

    fun getUser(userId: String): Mono<User> = userRepository.findById(userId)

    fun getUsers(): Flux<User> = userRepository.findAll()
}