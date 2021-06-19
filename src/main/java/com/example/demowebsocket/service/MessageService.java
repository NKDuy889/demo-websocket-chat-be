package com.example.demowebsocket.service;

import java.util.List;

public interface MessageService<E> {

    E save(E e);

    List<E> getListMessagesByConversation(Long idConversation);

    String getNameUser(Long idUser);
}
