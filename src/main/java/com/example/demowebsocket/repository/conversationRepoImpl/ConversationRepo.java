package com.example.demowebsocket.repository.conversationRepoImpl;

import com.example.demowebsocket.dto.CateBoxChatDTO;
import com.example.demowebsocket.model.Conversation;
import com.example.demowebsocket.model.ConversationDTO;

import java.util.List;

public interface ConversationRepo {
    Conversation getConversations(ConversationDTO conversationDTO);
    List<Conversation> getListConversation(Long idUser);
    boolean checkConversaationExists(CateBoxChatDTO cateBoxChatDTO);
}
