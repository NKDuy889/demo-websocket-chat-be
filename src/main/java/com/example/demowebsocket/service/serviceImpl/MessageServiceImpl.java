package com.example.demowebsocket.service.serviceImpl;

import com.example.demowebsocket.model.Message;
import com.example.demowebsocket.repository.MessageRepository;
import com.example.demowebsocket.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService<Message> {


    @Autowired
    private MessageRepository messageRepository;


    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getListMessagesByConversation(Long idConversation) {
        return messageRepository.getListMessages(idConversation);
    }

    @Override
    public String getNameUser(Long idUser) {
        return messageRepository.getNameById(idUser);
    }
}
