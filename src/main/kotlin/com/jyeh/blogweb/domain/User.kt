package com.jyeh.blogweb.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class User(private val username: String, private val password: String) {
    @Id
    var id: String? = null
}