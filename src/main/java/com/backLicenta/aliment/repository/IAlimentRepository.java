package com.backLicenta.aliment.repository;

import com.backLicenta.aliment.domain.Aliment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlimentRepository extends JpaRepository<Aliment,Integer>{
    Aliment findById(int id);
}
