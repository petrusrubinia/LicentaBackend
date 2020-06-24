package com.backLicenta.aliment.repository;

import com.backLicenta.aliment.domain.Aliment;
import com.backLicenta.user.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IAlimentRepositoryImpl implements IAlimentRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Aliment> findAllByUserId(int id) {
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM licenta.alimente WHERE id_user ="+ id, Aliment.class);
            List<Aliment> list = query.getResultList();
            System.out.println(list);
            return list;
    }catch (Exception e)
        {
            return new ArrayList<>();
        }
        }

    @Override
    public List<Aliment> getAllWithTempQuantity() {
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM licenta.alimente WHERE temperatura <>"+ -100 + " and cantitate <>" + "''", Aliment.class);
            List<Aliment> list = query.getResultList();
            System.out.println(list);
            return list;
        }catch (Exception e)
        {
            return new ArrayList<>();
        }
    }
}
