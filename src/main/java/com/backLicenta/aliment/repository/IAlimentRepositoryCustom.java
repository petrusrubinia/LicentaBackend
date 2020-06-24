package com.backLicenta.aliment.repository;

import com.backLicenta.aliment.domain.Aliment;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAlimentRepositoryCustom {
    List<Aliment> findAllByUserId(int id);
    List<Aliment> getAllWithTempQuantity();
}
