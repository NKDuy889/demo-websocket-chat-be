package com.example.demowebsocket.service.serviceImpl;

import com.example.demowebsocket.model.Conversation;
import com.example.demowebsocket.repository.ConversationRepository;
import com.example.demowebsocket.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationServiceImpl implements ConversationService<Conversation> {
    @Autowired
    private ConversationRepository conversationRepository;

    @Override
    public List<Conversation> findConversationsByUser() {
        return null;
    }

    @Override
    public Conversation save(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

}
