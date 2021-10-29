package org.movies.infrastructure.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RabbitConfig {

    public static final String QUEUE_NAME = "Queue";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME);
    }

//    @Profile("sender")
    @Bean
    public Sender sender(){
        return new Sender();
    }
}