package es.innoit.delivery.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BasicController {
    @GetMapping(path = ["/isAlive"])
    fun create() = "=)"
}

