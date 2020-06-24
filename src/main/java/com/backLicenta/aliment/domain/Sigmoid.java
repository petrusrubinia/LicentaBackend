package com.backLicenta.aliment.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class Sigmoid {

    public Pereche sigmFct1;
    public Pereche sigmFct2;
    public Pereche sigmFct3;
    public Pereche sigmFct4;
    public Pereche gaussFct;

    public Sigmoid(Pereche sigmFct1, Pereche sigmFct2, Pereche sigmFct3, Pereche sigmFct4, Pereche gaussFct) {
        this.sigmFct1 = sigmFct1;
        this.sigmFct2 = sigmFct2;
        this.sigmFct3 = sigmFct3;
        this.sigmFct4 = sigmFct4;
        this.gaussFct = gaussFct;
    }

    public double applySigmoidFunction(Pereche params, double x){
        return 1/(1+Math.exp(-params.getA()*(x-params.getB())));
    }
    public double applyGuassFunction(Pereche params, double x){
        return Math.exp(-(((x-params.getB())*(x-params.getB()))/(2*params.getA()*params.getA())));

    }
    public List<Double> sigmoidAndGauss(double val){
        List<Double> list = new ArrayList<>();
        list.add(round(applySigmoidFunction(sigmFct1,val),2));
        list.add(round(applySigmoidFunction(sigmFct2,val),2));
        list.add(round(applyGuassFunction(gaussFct,val),2));
        list.add(round(applySigmoidFunction(sigmFct3,val),2));
        list.add(round(applySigmoidFunction(sigmFct4,val),2));
        return list;
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
