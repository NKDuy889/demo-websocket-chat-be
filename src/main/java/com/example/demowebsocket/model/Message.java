package com.example.demowebsocket.model;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String textMessage;

    @Column(name = "id_conversation")
    private Long idConversation;

    public Message(){};
    public Message(String textMessage){
        this.textMessage = textMessage;
    }

    public Message(String textMessage, Long idConversation) {
        this.textMessage = textMessage;
        this.idConversation = idConversation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public Long getIdConversation() {
        return idConversation;
    }

    public void setIdConversation(Long idConversation) {
        this.idConversation = idConversation;
    }
}
