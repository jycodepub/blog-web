package com.jyeh.blogweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlogWebApplication

fun main(args: Array<String>) {
    runApplication<BlogWebApplication>(*args)
}
