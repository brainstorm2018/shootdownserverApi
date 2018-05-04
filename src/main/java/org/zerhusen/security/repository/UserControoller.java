package org.zerhusen.security.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zerhusen.model.security.Authority;
import org.zerhusen.model.security.History;
import org.zerhusen.model.security.User;
import org.zerhusen.security.JwtUser;
import org.zerhusen.security.JwtUserFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserControoller {


    @Autowired
    EntityManager em;


    public void saveHisory(History history) {

        if (history.getId() == null) {
            em.persist(history);
        } else {
            em.merge(history);
        }

    }

    public History findById(Long id) {
        return em.find(History.class, id);
    }



}
