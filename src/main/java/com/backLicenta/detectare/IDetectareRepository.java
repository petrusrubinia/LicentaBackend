package com.backLicenta.detectare;

import com.backLicenta.aliment.domain.Aliment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetectareRepository extends JpaRepository<Aliment,Integer> {
}
