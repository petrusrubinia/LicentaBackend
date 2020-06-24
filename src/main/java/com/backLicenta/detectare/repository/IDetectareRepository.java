package com.backLicenta.detectare.repository;

import com.backLicenta.detectare.domain.AlimentDetect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetectareRepository extends JpaRepository<AlimentDetect,Integer> {
}
