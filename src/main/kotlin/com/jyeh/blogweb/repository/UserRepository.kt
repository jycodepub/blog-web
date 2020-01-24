package com.jyeh.blogweb.repository

import com.jyeh.blogweb.domain.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : ReactiveMongoRepository<User, String> {
}