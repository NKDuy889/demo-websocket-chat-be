package com.example.demowebsocket.repository.conversationRepoImpl;

import com.example.demowebsocket.model.Conversation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ConversationRepoImpl implements ConversationRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Conversation> getConversations(String idUser, String idConversation) {
        StringBuilder sql = new StringBuilder();
        sql.append("from Conversation c " +
                "inner join CateBoxChat cbc on c.id = cbc.id_conversation" +
                "inner join Users u on cbc.id_user = u.id" +
                "where c.id = " +  idUser +
                "and u.id = " + idConversation);
        return entityManager.createNativeQuery(sql.toString()).getResultList();
    }
}
