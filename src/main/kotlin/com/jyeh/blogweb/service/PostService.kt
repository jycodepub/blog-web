package com.jyeh.blogweb.service

import com.jyeh.blogweb.domain.Post
import com.jyeh.blogweb.repository.CommentRepository
import com.jyeh.blogweb.repository.PostRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.function.Consumer

@Service
class PostService(private val postRepository: PostRepository,
                  private val commentRepository: CommentRepository) {

    fun addPost(post: Post): Mono<Post> = postRepository.save(post)

    fun getPosts(userId: String): Flux<Post> = postRepository.getPostsByUserId(userId)

    fun deletePost(id: String): Mono<Void> = commentRepository
            .deleteAll(commentRepository.getCommentsByPostId(id))
            .then(postRepository.deleteById(id))

    fun deletePosts(userId: String): Mono<Void> =
        postRepository.getPostsByUserId(userId).doOnNext {
            deletePost(it.userId)
        }.then()

}