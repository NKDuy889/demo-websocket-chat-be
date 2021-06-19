package com.example.demowebsocket.service;

import com.example.demowebsocket.dto.CateBoxChatDTO;
import com.example.demowebsocket.model.Conversation;
import com.example.demowebsocket.model.ConversationDTO;

import java.util.List;

public interface ConversationService<E> {
    List<E> findConversationsByUser(Long idUser);

    E save(E e);

    E getConversations(ConversationDTO conversationDTO);

    Conversation saveConversations(CateBoxChatDTO cateBoxChatDTO, Conversation Conversation);
}
