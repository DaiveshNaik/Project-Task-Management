package com.daivesh.service;

import java.util.List;

import com.daivesh.exception.ChatException;
import com.daivesh.exception.ProjectException;
import com.daivesh.model.Chat;

public interface ChatService {

	Chat createChat(Chat chat);

	// Chat getChatsByProjectId(Long projectId) throws ChatException,
	// ProjectException;

	// Chat addUsersToChat(Long chatId, List<Long> userIds) throws ChatException;

	// List<Chat> searchChatsByName(String name) throws ChatException;

	// Other methods as needed
}
