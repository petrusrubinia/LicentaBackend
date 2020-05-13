package com.backLicenta.detectare;


import com.backLicenta.aliment.domain.Aliment;
import com.backLicenta.aliment.service.IAlimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@RequestMapping(value = "/aliment")
@RestController
public class DetectareFructeLegumeApi {
    //private final IAlimentService alimentService;
    private final IDetectareService detectareService;

    @Autowired
    public DetectareFructeLegumeApi(final IDetectareService detectareService) {
        this.detectareService = detectareService;
    }

    @RequestMapping(value = "/detectare", headers = "Content-Type= multipart/form-data", method = RequestMethod.POST)
    public List<Aliment> fileUpload(@RequestParam("file") MultipartFile file) {

        byte[] photo = null;
        try {
            photo = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = file.getOriginalFilename();

        return detectareService.detect(photo, name);

    }
}