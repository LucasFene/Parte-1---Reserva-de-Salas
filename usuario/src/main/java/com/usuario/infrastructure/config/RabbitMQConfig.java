package com.usuario.infrastructure.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String RESERVA_QUEUE = "reservaQueue";

    @Bean
    public Queue reservaQueue() {
        return new Queue(RESERVA_QUEUE, false);
    }
}
