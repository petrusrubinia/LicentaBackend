package com.backLicenta.aliment.repository;

import com.backLicenta.aliment.domain.Aliment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IAlimentRepository extends JpaRepository<Aliment,Integer>, IAlimentRepositoryCustom {
    Aliment findById(int id);
}
