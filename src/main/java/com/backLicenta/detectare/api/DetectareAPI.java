package com.backLicenta.detectare.api;


import com.backLicenta.detectare.domain.AlimentDetect;
import com.backLicenta.detectare.service.IDetectareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RequestMapping(value = "/aliment")
@RestController
public class DetectareAPI {
    //private final IAlimentService alimentService;
    private final IDetectareService detectareService;

    @Autowired
    public DetectareAPI(final IDetectareService detectareService) {
        this.detectareService = detectareService;
    }

    @RequestMapping(value = "/detectare", headers = "Content-Type= multipart/form-data", method = RequestMethod.POST)
    public List<AlimentDetect> fileUpload(@RequestParam("file") MultipartFile file) {

        byte[] photo = null;
        try {
            photo = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = file.getOriginalFilename();

        return detectareService.detect(photo, name);

    }
    @RequestMapping(value = "/stergere", headers = "Content-Type= multipart/form-data", method = RequestMethod.POST)
    public List<AlimentDetect> videoUpload(@RequestParam("file") MultipartFile file) {

        byte[] video = null;
        try {
            video = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = file.getOriginalFilename();

        return detectareService.remove(video, name);

    }

}