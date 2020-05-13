package com.backLicenta.detectare;

import com.backLicenta.aliment.domain.Aliment;

import java.util.List;

public interface IDetectareService {
    List<Aliment> detect(byte[] bytes, String name);
    void savePhoto(byte[] bytes, String name);
    List<Aliment> detectFruitVegetables(String name);
}
