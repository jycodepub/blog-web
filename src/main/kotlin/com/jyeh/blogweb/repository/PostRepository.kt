package com.jyeh.blogweb.repository

import com.jyeh.blogweb.domain.Post
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface PostRepository : ReactiveMongoRepository<Post, String> {
    fun getPostsByUserId(userId: String): Flux<Post>
}