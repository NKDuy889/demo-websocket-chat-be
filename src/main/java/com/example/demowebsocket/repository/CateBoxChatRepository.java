package com.example.demowebsocket.repository;

import com.example.demowebsocket.model.CateBoxChat;
import com.example.demowebsocket.repository.cateBoxChatRepoImpl.CateBoxChatRepo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CateBoxChatRepository extends JpaRepository<CateBoxChat, Long>, CateBoxChatRepo {
}
