package com.example.demowebsocket.repository.messageRepoImpl;

import com.example.demowebsocket.model.Message;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class MessageRepoImpl implements MessageRepo{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Message> getListMessages(Long idConversation) {
        StringBuilder sql = new StringBuilder();
        sql.append("from Message where id_conversation = " + idConversation + " order by id asc");
        return entityManager.createQuery(sql.toString()).getResultList();
    }

    @Override
    public String getNameById(Long idUser) {
        String sql = "select c from Users c inner join Message m on c.id = m.idUser where c.id = " + idUser
                + " group by c.name";
        return entityManager.createQuery(sql).getSingleResult().toString();
    }
}
