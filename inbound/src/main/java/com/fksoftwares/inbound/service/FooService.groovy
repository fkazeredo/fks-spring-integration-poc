package com.fksoftwares.inbound.service

import com.fksoftwares.inbound.model.FooDTO
import org.springframework.messaging.Message
import org.springframework.stereotype.Component

@Component
class FooService {

    void handle(Message<FooDTO> message) {
        println(message.payload.foo)
        println(message.payload.bar)
    }
}