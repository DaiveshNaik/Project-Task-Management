package com.daivesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daivesh.exception.ChatException;
import com.daivesh.exception.ProjectException;
import com.daivesh.exception.UserException;
import com.daivesh.model.Chat;
import com.daivesh.model.Message;
import com.daivesh.model.User;
import com.daivesh.request.CreateMessageRequest;
import com.daivesh.service.MessageService;
import com.daivesh.service.ProjectService;
import com.daivesh.service.UserService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody CreateMessageRequest request)
            throws UserException, ChatException, ProjectException {

        User user = userService.findUserById(request.getSenderId());
        if (user == null)
            throw new UserException("user Not found with id " + request.getSenderId());
        Chat chats = projectService.getProjectById(request.getProjectId()).getChat(); // This method should throw
                                                                                      // ChatException if the chat is
                                                                                      // not found
        if (chats == null)
            throw new ChatException("Chats not found");
        Message sentMessage = messageService.sendMessage(request.getSenderId(), request.getProjectId(),
                request.getContent());
        return ResponseEntity.ok(sentMessage);
    }

    @GetMapping("/chat/{projectId}")
    public ResponseEntity<List<Message>> getMessagesByChatId(@PathVariable Long projectId)
            throws ProjectException, ChatException {
        List<Message> messages = messageService.getMessagesByProjectId(projectId);
        return ResponseEntity.ok(messages);
    }
}
