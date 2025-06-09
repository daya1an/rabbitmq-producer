package com.dayalan.rabbitmq_producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class MesagePublisher {

    private static final Logger log = LoggerFactory.getLogger(MesagePublisher.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/publish")
    public String publishMessage(MessageDto messageDto) {

        messageDto.setMessageId(UUID.randomUUID().toString());
        messageDto.setMessageDate(new Date());

        rabbitTemplate.convertAndSend(MqConfig.EXCHANGE, MqConfig.ROUTINGKEY, messageDto);

        log.info("Message published: {}", messageDto);

        return "Message published successfully";
    }
}
