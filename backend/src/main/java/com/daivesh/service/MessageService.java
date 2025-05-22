package com.daivesh.service;

import java.util.List;

import com.daivesh.exception.ChatException;
import com.daivesh.exception.ProjectException;
import com.daivesh.exception.UserException;
import com.daivesh.model.Message;

public interface MessageService {

    Message sendMessage(Long senderId, Long chatId, String content)
            throws UserException, ChatException, ProjectException;

    List<Message> getMessagesByProjectId(Long projectId) throws ProjectException, ChatException;
}
