package com.backLicenta.detectare.service;

import com.backLicenta.detectare.domain.AlimentDetect;

import java.util.List;

public interface IDetectareService {
    List<AlimentDetect> detect(byte[] bytes, String name);
    void savePhoto(byte[] bytes, String name);
    List<AlimentDetect> detectFruitVegetables(String name);

    List<AlimentDetect> remove(byte[] video, String name);
}
