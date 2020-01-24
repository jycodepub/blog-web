package com.jyeh.blogweb.service

import com.jyeh.blogweb.domain.Comment
import com.jyeh.blogweb.repository.CommentRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class CommentService(private val commentRepository: CommentRepository) {
    companion object {
        val log = LoggerFactory.getLogger(CommentRepository::class.java)
    }

    fun addComment(comment: Comment) = commentRepository.save(comment)
            .subscribe{ log.debug("Saved comment: {}", it.id) }

    fun getComments(postId: String): Flux<Comment> = commentRepository.getCommentsByPostId(postId)

    fun deleteComment(id: String) = commentRepository.deleteById(id)
            .subscribe { log.debug("Deleted comment: {}", id) }

    fun deleteComments(postId: String) = getComments(postId).doOnNext { deleteComment(it.id!!) }.then()
}