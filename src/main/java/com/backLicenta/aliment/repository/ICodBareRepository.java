package com.backLicenta.aliment.repository;

import com.backLicenta.aliment.domain.Aliment;
import com.backLicenta.aliment.domain.CodDeBare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodBareRepository extends JpaRepository<CodDeBare,String> {
}