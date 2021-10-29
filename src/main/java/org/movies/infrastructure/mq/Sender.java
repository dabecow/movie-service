package org.movies.infrastructure.mq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void send(String message){
        template.convertAndSend(queue.getName(), message);
        System.out.println("Sent: " + message);
    }

}
