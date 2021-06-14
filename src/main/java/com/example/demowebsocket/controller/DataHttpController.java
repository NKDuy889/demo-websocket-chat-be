package com.example.demowebsocket.controller;

import com.example.demowebsocket.model.Conversation;
import com.example.demowebsocket.model.ConversationDTO;
import com.example.demowebsocket.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("")
public class DataHttpController {
    @Autowired
    private ConversationService conversationService;

    @GetMapping("/conversation")
    public ResponseEntity<Conversation> getConversations(@RequestBody ConversationDTO conversationDTO){
        return new ResponseEntity(conversationService.getConversations(conversationDTO), HttpStatus.OK);
    }
}
