package com.example.demowebsocket.repository.conversationRepoImpl;

import com.example.demowebsocket.dto.CateBoxChatDTO;
import com.example.demowebsocket.model.CateBoxChat;
import com.example.demowebsocket.model.Conversation;
import com.example.demowebsocket.model.ConversationDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ConversationRepoImpl implements ConversationRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Conversation getConversations(ConversationDTO conversationDTO) {
        StringBuilder sql = new StringBuilder();
        sql.append("select c from Conversation c");
        sql.append(" inner join CateBoxChat cbc on c.id = cbc.idConversation");
        sql.append(" inner join Users u on cbc.idUser = u.id");
        sql.append(" where c.id = " + conversationDTO.getIdUser());
        sql.append(" and u.id = " + conversationDTO.getIdConversation());
        return (Conversation) entityManager.createQuery(sql.toString()).getSingleResult();
    }

    @Override
    public List<Conversation> getListConversation(Long idUser) {
        StringBuilder sql = new StringBuilder();
        sql.append("from Conversation as c where 1=1");
        sql.append(" inner join CateBoxChat as cbc on c.id = cbc.idConversation ");
        sql.append(" where cbc.idUser = " + idUser);
        return entityManager.createQuery(sql.toString()).getResultList();
    }

    @Override
    public boolean checkConversaationExists(CateBoxChatDTO cateBoxChatDTO) {
        String sql = "select c from Conversation c where c.id in " +
                "( select idConversation from CateBoxChat cbc where (cbc.idUser = 2 or cbc.idUser = 5) group by cbc.idConversation)";
//        return entityManager.createQuery(sql).getResultList().size() > 1;
        return false;
    }
}
