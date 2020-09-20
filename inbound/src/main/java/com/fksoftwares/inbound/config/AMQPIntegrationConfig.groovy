package com.fksoftwares.inbound.config

import com.fksoftwares.inbound.model.FooDTO
import com.fksoftwares.inbound.service.FooService
import groovy.transform.CompileStatic
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.amqp.dsl.Amqp
import org.springframework.integration.annotation.IntegrationComponentScan
import org.springframework.integration.dsl.IntegrationFlow
import org.springframework.integration.dsl.IntegrationFlows
import org.springframework.integration.dsl.Transformers

@Configuration
@IntegrationComponentScan
@CompileStatic
class AMQPIntegrationConfig {

    @Bean
    IntegrationFlow amqpInboundGateway(ConnectionFactory connectionFactory, FooService fooService) {
        return IntegrationFlows
                .from(Amqp.inboundGateway(connectionFactory, "rk.integration.queue"))
                .channel("inputChannel")
                .transform(Transformers.fromJson(FooDTO.class))
                .handle(fooService, "handle")
                .get()
    }
}