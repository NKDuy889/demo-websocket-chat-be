package com.example.demowebsocket.service;

import java.util.List;

public interface ConversationService<E> {
    List<E> findConversationsByUser();

    E save(E e);


}
