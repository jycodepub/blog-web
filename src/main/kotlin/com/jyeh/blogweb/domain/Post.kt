package com.jyeh.blogweb.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Post(val userId: String,
                val title: String,
                val post: String,
                val timestamp: LocalDateTime) {
    @Id
    var id: String? = null
}