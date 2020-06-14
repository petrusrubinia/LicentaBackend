package com.backLicenta.user.repository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import com.backLicenta.user.domain.User;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class IUserRepositoryImpl implements IUserRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    public User login(User user, BCryptPasswordEncoder encoder) {
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM licenta.user WHERE utilizator = '"+ user.getUtilizator()+ "'",User.class);
            //query.setParameter(1, user.getUtilizator() + "%");
           // query.setParameter(2, user.getParola() + "%");
            List<User> list = query.getResultList();
            System.out.println(list.get(0).getParola());
            System.out.println(user.getParola());
            User userToReturn;
            if(list.size() != 0 && encoder.matches(user.getParola(),list.get(0).getParola()))
            {
                userToReturn = new User(list.get(0).getId(),list.get(0).getNume(),list.get(0).getPrenume(),list.get(0).getEmail(),list.get(0).getUtilizator(),user.getParola());
                return userToReturn;
            }
            else
                return new User(0,"","","","","");
        }catch (Exception e) {
            return new User(0,"","","","","");
        }
    }

    @Override
    public boolean exist(User user) {
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM licenta.user WHERE utilizator = '"+ user.getUtilizator()+"' and  email = '"+ user.getEmail() + "'",User.class);
            if(query.getResultList().size()!=0)
                return true;
            else
                return false;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean update(User newUser) {
        try {
            System.out.println(newUser.getNume());
            entityManager.createNativeQuery("update licenta.user set nume = '"+newUser.getNume()+"', prenume = '"+newUser.getPrenume()+"', email ='"+ newUser.getEmail()+ "', utilizator= '"+ newUser.getUtilizator()+"', parola= '"+newUser.getParola()+"' where id = " + newUser.getId()).executeUpdate();
            System.out.println("tot in try");
            //
            return true;
        }catch (Exception e) {
            System.out.println(e);

            return false;
        }
    }

}
