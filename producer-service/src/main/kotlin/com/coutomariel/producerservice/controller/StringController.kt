package com.coutomariel.producerservice.controller

import com.coutomariel.producerservice.services.StringService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/produces")
class StringController(
        val service: StringService
) {

    @GetMapping
    fun produces(@RequestParam("message") message: String): ResponseEntity<Any> {
        service.produce(message)
        return ResponseEntity.ok().body("Sending message")
    }

}