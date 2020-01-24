package com.jyeh.blogweb.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
class Comment(val postId: String,
              val author: String,
              val comment: String,
              val timestamp: LocalDateTime) {
    @Id
    var id: String? = null
}