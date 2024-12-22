package com.example.kotlinproject

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TestConfig {

    @Bean
    fun appRunner(): CommandLineRunner {
        return CommandLineRunner { }
    }
}
