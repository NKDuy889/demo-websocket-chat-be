package com.example.demowebsocket.repository.conversationRepoImpl;

import com.example.demowebsocket.model.Conversation;
import com.example.demowebsocket.model.ConversationDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ConversationRepoImpl implements ConversationRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Conversation getConversations(ConversationDTO conversationDTO) {
        StringBuilder sql = new StringBuilder();
        sql.append("select c.id,c.name,c.avatar from Conversation as c " +
                " inner join cate_box_chat as cbc on c.id = cbc.id_conversation " +
                " inner join users as u on cbc.id_user = u.id " +
                " where c.id = " + conversationDTO.getIdUser() +
                " and u.id = " + conversationDTO.getIdConversation());
        return Conversation.class.cast(entityManager.createNativeQuery(sql.toString()).getSingleResult());
    }
}
