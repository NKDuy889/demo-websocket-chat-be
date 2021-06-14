package com.example.demowebsocket.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
@Component
public class WebSocketEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketEventListener.class);


    @EventListener
    public void handlerWebSocketConnectListener(SessionConnectedEvent event){
        LOGGER.info("Received a new web socket connection ::" + event.getMessage());
    }
//
    @EventListener
    public void handlerWebSocketDisconnectListener(SessionConnectedEvent event){
        LOGGER.info("handlerWebSocketDisconnectListener" + event.getMessage());
    }
}
