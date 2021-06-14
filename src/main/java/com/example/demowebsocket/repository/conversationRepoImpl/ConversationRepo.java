package com.example.demowebsocket.repository.conversationRepoImpl;

import com.example.demowebsocket.model.Conversation;

import java.util.List;

public interface ConversationRepo {
    List<Conversation> getConversations(String idUser, String idConversation);
}
