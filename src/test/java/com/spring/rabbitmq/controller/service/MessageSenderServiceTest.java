package com.spring.rabbitmq.controller.service;

import com.spring.rabbitmq.service.MessageSenderService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.amqp.core.AmqpTemplate;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;


public class MessageSenderServiceTest {

    private MessageSenderService messageSender;

    @Mock
    private AmqpTemplate amqpTemplate;

    @Before
    public void setUp() {
        initMocks(this);
        messageSender = new MessageSenderService(amqpTemplate);
    }

    @Test
    public void sendMessageShouldSendMessageToAmqpTemplate() throws Exception {
        String message = "Test message";

        messageSender.sendMessage(message);

        verify(amqpTemplate).convertAndSend("my.first.exchange", "My First Message", message);
    }
}