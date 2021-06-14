package com.example.demowebsocket.repository;

import com.example.demowebsocket.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ConversationRepository extends JpaRepository<Conversation, Long> {

}

