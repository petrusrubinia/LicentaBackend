package com.backLicenta.user.repository;

import org.springframework.stereotype.Repository;
import com.backLicenta.user.domain.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class IUserRepositoryImpl implements IUserRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    public boolean login(User user) {
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM licenta.user WHERE utilizator = '"+ user.getUtilizator()+"'",User.class);
            //query.setParameter(1, user.getUtilizator() + "%");
           // query.setParameter(2, user.getParola() + "%");
            if(query.getResultList().size()!=0)
                return true;
            else
                return false;
        }catch (Exception e) {
            return false;
        }
    }

}
