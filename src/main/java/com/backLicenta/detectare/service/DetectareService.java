package com.backLicenta.detectare.service;

import com.backLicenta.detectare.domain.Aliment;
import com.backLicenta.detectare.repository.IDetectareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DetectareService implements IDetectareService {
    private final String path;
    private final IDetectareRepository iDetectareRepository;

    @Autowired
    public DetectareService(final IDetectareRepository iDetectareRepository) {
        this.path = "\\src\\main\\resources\\photos\\";
        this.iDetectareRepository = iDetectareRepository;
    }

    @Override
    public List<Aliment> detect(byte[] bytes, String name) {
        savePhoto(bytes, name);
        return detectFruitVegetables(name);
    }
    @Override
    public List<Aliment> detectFruitVegetables(String name) {
        //se detecteaza alimentele din imaginea path+name
        List<Aliment> list = new ArrayList();
        //list.add(new Aliment("" ,"fructEg2","fructe","200",2,"20-10-2020","22-10-2020"));
        Aliment aliment = new Aliment(2,"cod","nume","categorie","cantitate",3,4,"exp","achi");
        return list;
    }

    @Override
    public List<Aliment> remove(byte[] video, String name) {
        return null;
    }

    @Override
    public void savePhoto(byte[] bytes, String name) {
        try {
            String path_actualImg = path + name;
            File newFile = new File("D:\\Facultate\\Licenta\\Backend\\src\\main\\resources\\photos\\"+ name);
            newFile.createNewFile();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException ex) {
            System.out.println("nu s-a salvat");
        }
    }
}
