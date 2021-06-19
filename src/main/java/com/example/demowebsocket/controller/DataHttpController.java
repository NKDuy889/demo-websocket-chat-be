package com.example.demowebsocket.controller;

import com.example.demowebsocket.dto.CateBoxChatDTO;
import com.example.demowebsocket.model.*;
import com.example.demowebsocket.service.CateBoxChatService;
import com.example.demowebsocket.service.ConversationService;
import com.example.demowebsocket.service.MessageService;
import com.example.demowebsocket.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("")
public class DataHttpController {
    @Autowired
    private ConversationService conversationService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private MessageService messageService;

    @Autowired
    private CateBoxChatService cateBoxChatService;

    @Autowired
    private UsersService usersService;


    @GetMapping(value = "/list-conversation-by-user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Conversation>> getListConversation(@PathVariable("id") Long idUser){
        return new ResponseEntity<>(conversationService.findConversationsByUser(idUser),HttpStatus.OK);
    }

    @PostMapping("/get-conversation")
    public ResponseEntity<Conversation> getConversations(@RequestBody ConversationDTO conversationDTO){

//        simpMessagingTemplate.convertAndSend("/topic/greetings", "hi e");
        return new ResponseEntity(conversationService.getConversations(conversationDTO), HttpStatus.OK);
    }

    @PostMapping("/create-conversation")
    public ResponseEntity<Conversation> createConversation(@RequestBody CateBoxChatDTO cateBoxChatDTO,@RequestBody Conversation conversation){
        return new ResponseEntity(conversationService.saveConversations(cateBoxChatDTO, conversation),HttpStatus.OK);
    }

    @PostMapping("/get-list-message")
    public ResponseEntity<List<Message>> message(@RequestBody Long idConversation){
//        simpMessagingTemplate.convertAndSend("/topic/greetings/" + Long.parseLong(obj.toString()));
        return new ResponseEntity(messageService.getListMessagesByConversation(idConversation), HttpStatus.OK);
    }

    @PostMapping("/send-message")
    public ResponseEntity<Conversation> sendMessage(@RequestBody ConversationDTO conversationDTO){
//        send socket
        return new ResponseEntity(conversationService.getConversations(conversationDTO), HttpStatus.OK);
    }



    @PostMapping("/create-message")
    public ResponseEntity<Message> createMessage(@RequestBody Message message){
        System.out.println("/topic/greetings/" + message.getIdConversation());
        simpMessagingTemplate.convertAndSend("/topic/greetings/" + message.getIdConversation(), message);
        return new ResponseEntity(messageService.save(message),HttpStatus.OK);
    }

    @PostMapping("/create-cateBoxChat")
    public ResponseEntity<CateBoxChat> createCateBoxChat(@RequestBody CateBoxChat cateBoxChat){
        return new ResponseEntity(cateBoxChatService.save(cateBoxChat),HttpStatus.OK);
    }

    @PostMapping("/get-name-user")
    public ResponseEntity<String> getNameUser(@RequestBody Long idUser){
        return new ResponseEntity(messageService.getNameUser(idUser),HttpStatus.OK);
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<List<Users>> getAllUsers(){
        return new ResponseEntity<>(usersService.getAllUsers(),HttpStatus.OK);
    }
}
