package com.example.demowebsocket.service.serviceImpl;

import com.example.demowebsocket.model.CateBoxChat;
import com.example.demowebsocket.repository.CateBoxChatRepository;
import com.example.demowebsocket.service.CateBoxChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CateBoxChatServiceImpl implements CateBoxChatService<CateBoxChat> {
    @Autowired
    private CateBoxChatRepository cateBoxChatRepository;

    @Override
    public CateBoxChat save(CateBoxChat cateBoxChat) {
        return cateBoxChatRepository.save(cateBoxChat);
    }
}
