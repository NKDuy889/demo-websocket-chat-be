package com.example.demowebsocket.service.serviceImpl;

import com.example.demowebsocket.model.Conversation;
import com.example.demowebsocket.model.ConversationDTO;
import com.example.demowebsocket.repository.ConversationRepository;
import com.example.demowebsocket.repository.conversationRepoImpl.ConversationRepo;
import com.example.demowebsocket.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationServiceImpl implements ConversationService<Conversation> {
    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private ConversationRepo conversationRepo;

    @Override
    public List<Conversation> findConversationsByUser() {
        return null;
    }

    @Override
    public Conversation save(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    @Override
    public Conversation getConversations(ConversationDTO conversationDTO) {
        return conversationRepo.getConversations(conversationDTO);
    }

}
