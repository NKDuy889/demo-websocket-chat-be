package com.example.demowebsocket.controller;

import com.example.demowebsocket.model.Conversation;
import com.example.demowebsocket.model.ConversationDTO;
import com.example.demowebsocket.model.Message;
import com.example.demowebsocket.service.ConversationService;
import com.example.demowebsocket.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@CrossOrigin("*")
public class WebSocketController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private ConversationService conversationService;


    public List<Message> sendMessage(@RequestBody Message message) {
        messageService.save(message);
        return messageService.getListMessagesByConversation(message.getIdConversation());
    }

    @MessageMapping("/message")
    @SendTo("/topic/greetings")
    public Conversation getConversations(@RequestBody ConversationDTO conversationDTO){
        return (Conversation) conversationService.getConversations(conversationDTO);
    }
}
