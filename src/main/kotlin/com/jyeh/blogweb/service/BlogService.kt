package com.jyeh.blogweb.service

class BlogService(private val userService: UserService, private val postService: PostService) {
    fun deleteUser(userId: String) {
        postService.deletePosts(userId).subscribe { userService.deleteUser(userId).subscribe() }
    }
}