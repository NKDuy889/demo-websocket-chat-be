package com.example.demowebsocket.repository.messageRepoImpl;

import com.example.demowebsocket.model.Message;

import java.util.List;

public interface MessageRepo {
    List<Message> getListMessages(Long idConversation);

    String getNameById(Long idUser);
}
