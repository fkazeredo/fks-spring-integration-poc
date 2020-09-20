package com.fksoftwares.outbound.config

import groovy.transform.CompileStatic
import org.springframework.amqp.rabbit.core.RabbitTemplate
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
    IntegrationFlow toOutboundQueueFlow(RabbitTemplate rabbitTemplate) {
        return IntegrationFlows.from("outputChannel")
                .transform(Transformers.toJson())
                .handle(Amqp.outboundAdapter(rabbitTemplate).routingKey("rk.integration.queue"))
                .get();
    }


}