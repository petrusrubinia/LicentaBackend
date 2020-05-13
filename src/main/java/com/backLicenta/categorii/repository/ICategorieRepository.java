package com.backLicenta.categorii.repository;
import com.backLicenta.categorii.domain.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategorieRepository extends JpaRepository<Categorie,Integer> {
    Categorie findById(int id);
}
