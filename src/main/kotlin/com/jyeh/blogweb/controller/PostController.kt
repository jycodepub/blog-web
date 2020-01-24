package com.jyeh.blogweb.controller

import com.jyeh.blogweb.domain.User
import com.jyeh.blogweb.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.core.publisher.onErrorReturn

@RestController
class BlogController(private val userService: UserService) {

    @PostMapping("/users")
    fun addUser(@RequestBody user: User): Mono<ResponseEntity<MutableMap<String, String>>> {
        val result: MutableMap<String, String> = HashMap()
        return userService.addUser(user)
                .doOnNext{u ->
                    result.put("status", "201")
                    result.put("id", u.id!!)
                }
                .thenReturn(ResponseEntity.status(HttpStatus.CREATED).body(result))
                .onErrorResume {t ->
                    result.put("status", "failed")
                    result.put("error", t.message?:"NA")
                    Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body(result))
                }


    }
}