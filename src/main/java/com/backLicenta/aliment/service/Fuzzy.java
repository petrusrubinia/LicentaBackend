package com.backLicenta.aliment.service;

import com.backLicenta.aliment.domain.Aliment;
import com.backLicenta.aliment.domain.Pereche;
import com.backLicenta.aliment.domain.Sigmoid;
import com.backLicenta.aliment.domain.Trapez;
import com.backLicenta.aliment.repository.Utils;
import org.apache.catalina.SessionIdGenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLOutput;
import java.util.List;

public class Fuzzy {
    private Trapez trapez;
    private Sigmoid sigm;
    private double C;
    private double CC;
    private Utils utils;

    public Fuzzy(List<Aliment> alimentList, Utils utils) {
        this.C = quantity(alimentList);
        this.CC = temperatureStorage(alimentList);
        this.utils = utils;
        createTrapez();
        createSigmoid();
    }
    private double quantity(List<Aliment> alimentList) {
        double sum = 0.0;
        for(int i = 0; i< alimentList.size(); i++)
        {
            sum+= (double) alimentList.get(i).getBucati()* (double)Integer.parseInt(alimentList.get(i).getCantitate());
        }
        return sum/1000;
    }

    private double temperatureStorage(List<Aliment> alimentList) {
        double up = 0.0;
        double down = 0.0;
        for(int i = 0; i< alimentList.size(); i++)
        {
            up += (double)alimentList.get(i).getTemperatura()*(double)alimentList.get(i).getBucati();
            down += (double)alimentList.get(i).getBucati();
        }
        return round(up/down,2);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    private void createSigmoid() {
        List<Pereche> listSigm = utils.readFromFile("D:\\Facultate\\Licenta\\Backend\\src\\main\\resources\\Sigmoid.txt");
        List<Pereche> listGauss = utils.readFromFile("D:\\Facultate\\Licenta\\Backend\\src\\main\\resources\\Gauss.txt");
        this.sigm = new Sigmoid(listSigm.get(0),listSigm.get(1), listSigm.get(2),listSigm.get(3),listGauss.get(0));
    }

    private void createTrapez() {
        List<Pereche> list = utils.readFromFile("D:\\Facultate\\Licenta\\Backend\\src\\main\\resources\\Trapez.txt");
        this.trapez = new Trapez(list.get(0),list.get(1), list.get(2), list.get(3),list.get(4),list.get(5),list.get(6));
    }

    public void fuzzy()
    {
        System.out.println("afisare C");
        System.out.println(C);
        System.out.println(" afisare CC");
        System.out.println(CC);
        System.out.println(defuzzify(calculateW(),FAMM(),3,5));
    }
    public double[][] calculateW(){
        List<Double> trapezResult = trapez.trapez(CC);
        System.out.println("--------AFISARE LISTA CC-----------");
        System.out.println(trapezResult);
        List<Double> sigmGaussResult = sigm.sigmoidAndGauss(C);
        System.out.println("-------AFISARE LISTA C-------------");
        System.out.println(sigmGaussResult);
        double[][] matrixW = new double[6][4];
        for (int i = 0; i< sigmGaussResult.size(); i++)
            for(int j = 0; j< trapezResult.size(); j++){
                matrixW[i][j] = minim(sigmGaussResult.get(i),trapezResult.get(j));
            }
        System.out.println("----------AFISARE TABEL W-------------");
        printResult(matrixW,sigmGaussResult.size(),trapezResult.size());
            return matrixW;
    }
    public double[][] FAMM(){
        double[][] matrixFAMM = new double[6][4];
        for (int i = 0 ; i< 5;i++)
            for(int j = 0; j< 3;j++)
            {
                matrixFAMM[i][j] = this.CC;
            }
        System.out.println("-------------AFISARE FAMM -------------");
            printResult(matrixFAMM,5,3);
        return matrixFAMM;
    }

    private void printResult(double[][] matrixResult, int size, int size2) {
        for (int i = 0; i< size; i++) {
            for (int j = 0; j < size2; j++)
                System.out.print(matrixResult[i][j]+ " ");
            System.out.println("\n");
        }
    }
    public double defuzzify(double[][] W,double[][] Z, int lungime, int latime)
    {
        System.out.println("-----------------REZULTAT FINAL---------------");
        double up = 0.0, down = 0.0;
        for(int i = 0; i < latime; i++)
            for (int j = 0; j < lungime; j++)
            {
                up += W[i][j]*Z[i][j];
                down += W[i][j];
            }
        return round(up/down,1);

    }

    private double minim(double a, double b){
        if( a < b)
            return a;
        return b;
    }
}
