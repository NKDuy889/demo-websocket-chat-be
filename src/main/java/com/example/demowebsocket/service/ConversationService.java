package com.example.demowebsocket.service;

import com.example.demowebsocket.model.ConversationDTO;

import java.util.List;

public interface ConversationService<E> {
    List<E> findConversationsByUser();

    E save(E e);

    E getConversations(ConversationDTO conversationDTO);
}
