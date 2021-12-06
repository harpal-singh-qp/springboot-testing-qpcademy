package com.example.training.springboottesting.app.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * CreatedBy Harpal Singh at 12/3/21
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue surveyCreatorQueue() {
        return new Queue("survey-creator-queue");
    }


    @Bean
    Binding testeBinding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("survey-routing-key");
    }


    @Bean
    DirectExchange exchange() {
        return new DirectExchange("direct-exchange");
    }
}
