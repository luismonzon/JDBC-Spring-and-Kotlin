package com.ericsson

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoreportsApplication

fun main(args: Array<String>) {
    SpringApplication.run(DemoreportsApplication::class.java,*args)

}


