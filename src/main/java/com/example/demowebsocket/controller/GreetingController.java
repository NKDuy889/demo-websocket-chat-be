package com.example.demowebsocket.controller;

import com.example.demowebsocket.model.ChatMessage;
import com.example.demowebsocket.model.Greeting;
import com.example.demowebsocket.model.HelloMessage;
import com.example.demowebsocket.model.Message;
import com.example.demowebsocket.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@CrossOrigin("*")
public class GreetingController {
    @Autowired
    private MessageService messageService;



    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) {
        try {
            Thread.sleep(1000); // simulated delay
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Greeting(message.getName());
    }

    @MessageMapping("/message")
    @SendTo("/topic/greetings")
    public List<Message> sendMessage(@RequestBody Message message) {
        messageService.save(message);
        return messageService.getListMessagesByConversation(message.getIdConversation());
    }
}
