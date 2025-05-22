package com.daivesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daivesh.exception.ChatException;
import com.daivesh.exception.ProjectException;
import com.daivesh.model.Chat;
import com.daivesh.model.User;
import com.daivesh.repository.ChatRepository;
import com.daivesh.repository.ProjectRepository;
import com.daivesh.repository.UserRepository;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }

    // @Override
    // public Chat addUsersToChat(Long chatId, List<Long> userIds) throws
    // ChatException {
    // Chat chat = chatRepository.findById(chatId)
    // .orElseThrow(() -> new ChatException("Chat not found with id: " + chatId));
    //
    // List<User> usersToAdd = userRepository.findAllById(userIds);
    //
    // chat.getUsers().addAll(usersToAdd);
    //
    // return chatRepository.save(chat);
    // }

    // @Override
    // public List<Chat> searchChatsByName(String name) throws ChatException {
    // List<Chat> searchedChats =
    // chatRepository.findByProjectNameContainingIgnoreCase(name);
    // if(searchedChats!=null) return searchedChats;
    // throw new ChatException("Chats not available");
    // }

    // Other methods as needed
}
