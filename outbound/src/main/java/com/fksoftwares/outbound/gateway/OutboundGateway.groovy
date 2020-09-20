package com.fksoftwares.outbound.gateway

import com.fksoftwares.outbound.model.FooDTO
import org.springframework.integration.annotation.MessagingGateway

@MessagingGateway(defaultRequestChannel = "outputChannel")
interface OutboundGateway {

    void sendToRabbit(FooDTO data)
}