package com.backLicenta.detectare.service;

import com.backLicenta.detectare.domain.Aliment;

import java.util.List;

public interface IDetectareService {
    List<com.backLicenta.detectare.domain.Aliment> detect(byte[] bytes, String name);
    void savePhoto(byte[] bytes, String name);
    List<Aliment> detectFruitVegetables(String name);

    List<Aliment> remove(byte[] video, String name);
}
