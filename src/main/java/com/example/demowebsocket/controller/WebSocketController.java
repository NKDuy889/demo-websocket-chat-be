package com.example.demowebsocket.controller;

import com.example.demowebsocket.model.Message;
import com.example.demowebsocket.service.ConversationService;
import com.example.demowebsocket.service.serviceImpl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;


@Controller
@CrossOrigin("*")
public class WebSocketController {

//    @MessageMapping("/message")
//    @SendTo("/topic/greetings")
//    public Message sendMessage(Message message) {
//        return message;
//    }



}
