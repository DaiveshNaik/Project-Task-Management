package com.daivesh.controller;

import com.daivesh.exception.ChatException;
import com.daivesh.exception.UserException;
import com.daivesh.model.Message;
import com.daivesh.service.ChatService;
import com.daivesh.service.MessageService;
import com.daivesh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RealTimeChatController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{groupId}")
    public Message sendToUser(@Payload Message message,

            @DestinationVariable String groupId) throws UserException, ChatException {

        simpMessagingTemplate.convertAndSendToUser(groupId, "/private",
                message);

        return message;
    }

}
