package com.spring.rabbitmq.controller;

import com.spring.rabbitmq.service.MessageSenderService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageSenderService messageSender;

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MessageController.class);

    @Autowired
    public MessageController(MessageSenderService messageSender) {
        this.messageSender = messageSender;
    }

    @RequestMapping(value = "", method = POST, consumes = "text/plain", produces = "text/plain")
    public String sendMessage(@RequestBody String message) {
        LOGGER.info("Inside controller");
        messageSender.sendMessage(message);
        return "200";
    }
}
