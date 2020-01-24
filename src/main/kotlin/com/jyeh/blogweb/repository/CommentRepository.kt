package com.jyeh.blogweb.repository

import com.jyeh.blogweb.domain.Comment
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface CommentRepository : ReactiveMongoRepository<Comment, String> {
    fun getCommentsByPostId(postId: String): Flux<Comment>
}