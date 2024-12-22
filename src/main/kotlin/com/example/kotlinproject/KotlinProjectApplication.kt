package com.example.kotlinproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@SpringBootApplication
class KotlinProjectApplication

fun main(args: Array<String>) {
    runApplication<KotlinProjectApplication>(*args)
}

@Component
class AppRunner(private val inputHandler: InputHandler) : CommandLineRunner {
    override fun run(vararg args: String?) {
        inputHandler.processInput(args.filterNotNull().toTypedArray())
    }
}
