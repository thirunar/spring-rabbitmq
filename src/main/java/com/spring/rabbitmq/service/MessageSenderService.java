package com.spring.rabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {

    private final static String EXCHANGE_NAME = "my.first.exchange";
    private final static String MESSAGE_TITLE = "my.first.queue";

    private AmqpTemplate amqpTemplate;

    @Autowired
    public MessageSenderService(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMessage(String message) {
        amqpTemplate.convertAndSend(EXCHANGE_NAME, MESSAGE_TITLE, message);
    }

}
