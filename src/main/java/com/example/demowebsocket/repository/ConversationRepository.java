package com.example.demowebsocket.repository;

import com.example.demowebsocket.model.Conversation;
import com.example.demowebsocket.repository.conversationRepoImpl.ConversationRepo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConversationRepository extends JpaRepository<Conversation, Long>, ConversationRepo {

}

