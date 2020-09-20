package com.fksoftwares.outbound

import com.fksoftwares.outbound.gateway.OutboundGateway
import com.fksoftwares.outbound.model.FooDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.integration.config.EnableIntegration

@SpringBootApplication
@EnableIntegration
class OutboundApplication implements ApplicationRunner {

    @Autowired
    private OutboundGateway gateway

    static void main(String[] args) {
        SpringApplication.run(OutboundApplication, args)
    }

    void run(ApplicationArguments args){
        def foo = new FooDTO("Hi, I'm Foo", "Hello, I'm Bar")
        def reply = gateway.sendToRabbit(foo)
        println(reply)
    }

}