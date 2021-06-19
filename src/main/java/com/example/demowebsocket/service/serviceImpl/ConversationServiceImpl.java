package com.example.demowebsocket.service.serviceImpl;

import com.example.demowebsocket.dto.CateBoxChatDTO;
import com.example.demowebsocket.model.Conversation;
import com.example.demowebsocket.model.ConversationDTO;
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
    public List<Conversation> findConversationsByUser(Long idUser) {
        return conversationRepository.getListConversation(idUser);
    }

    @Override
    public Conversation save(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    @Override
    public Conversation getConversations(ConversationDTO conversationDTO) {
        return conversationRepository.getConversations(conversationDTO);
    }

    @Override
    public Conversation saveConversations(CateBoxChatDTO cateBoxChatDTO, Conversation conversation) {
        if (!conversationRepository.checkConversaationExists(cateBoxChatDTO)) {
            return conversationRepository.save(conversation);
        }
        return conversationRepository.findById(conversation.getId()).get();
    }


}
