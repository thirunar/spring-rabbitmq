package com.spring.rabbitmq.controller;

import com.spring.rabbitmq.service.MessageSenderService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class MessageControllerTest {

    @Mock
    private MessageSenderService messageSender;

    private MessageController messageController;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        messageController = new MessageController(messageSender);
    }

    @Test
    public void sendMessageShouldSendMessageToTheQueue() throws Exception {
        String message = "Test Message";

        messageController.sendMessage(message);

        verify(messageSender).sendMessage(message);
    }
}