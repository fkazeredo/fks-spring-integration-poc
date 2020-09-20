package com.fksoftwares.inbound

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.integration.config.EnableIntegration

@SpringBootApplication
@EnableIntegration
class InboundApplication {

    static void main(String[] args) {
        SpringApplication.run(InboundApplication, args)
    }

}