package com.backLicenta.aliment.repository;

import com.backLicenta.aliment.domain.Pereche;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Utils {
    public Utils() {
    }

    //read trapez from file
    public List<Pereche> readFromFile(String file){
        BufferedReader reader;
        List<Pereche> list = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                // read next line
                String[] splitList = line.split(" ");
                Pereche interval = new Pereche(Double.parseDouble(splitList[0]), Double.parseDouble(splitList[1]));
                list.add(interval);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  list;
    }


}
