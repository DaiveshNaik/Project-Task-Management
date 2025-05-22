package com.daivesh.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daivesh.exception.ChatException;
import com.daivesh.exception.ProjectException;
import com.daivesh.exception.UserException;
import com.daivesh.model.Chat;
import com.daivesh.model.Message;
import com.daivesh.model.User;
import com.daivesh.repository.ChatRepository;
import com.daivesh.repository.MessageRepository;
import com.daivesh.repository.UserRepository;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectService projectService;

    @Override
    public Message sendMessage(Long senderId, Long projectId, String content)
            throws UserException, ChatException, ProjectException {
        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new UserException("User not found with id: " + senderId));

        Chat chat = projectService.getProjectById(projectId).getChat();

        Message message = new Message();
        message.setContent(content);
        message.setSender(sender);
        message.setCreatedAt(LocalDateTime.now());
        message.setChat(chat);
        Message savedMessage = messageRepository.save(message);

        chat.getMessages().add(savedMessage);
        return savedMessage;
    }

    @Override
    public List<Message> getMessagesByProjectId(Long projectId) throws ProjectException, ChatException {
        Chat chat = projectService.getChatByProjectId(projectId);
        List<Message> findByChatIdOrderByCreatedAtAsc = messageRepository.findByChatIdOrderByCreatedAtAsc(chat.getId());
        return findByChatIdOrderByCreatedAtAsc;
    }
}
