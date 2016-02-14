package com.spring.rabbitmq.service;


import org.slf4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;


public class MessageListenerService implements MessageListener {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MessageListenerService.class);

    @Override
    public void onMessage(Message message) {
        LOGGER.info(message.getMessageProperties().toString());;
        LOGGER.info(new String(message.getBody()));
    }
}
