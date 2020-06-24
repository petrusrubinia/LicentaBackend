package com.backLicenta.aliment.domain;

import java.util.ArrayList;
import java.util.List;

public class Trapez {

    private Pereche interval1;
    private Pereche interval2;
    private Pereche interval3;
    private Pereche intRight;
    private Pereche intRegular1;
    private Pereche intRegular2;
    private Pereche intLeft;

    public Trapez(Pereche interval1, Pereche interval2, Pereche interval3, Pereche intLeft, Pereche intRegular1, Pereche intRegular2, Pereche intRight) {
        this.interval1 = interval1;
        this.interval2 = interval2;
        this.interval3 = interval3;
        this.intRight = intRight;
        this.intRegular1 = intRegular1;
        this.intRegular2 = intRegular2;
        this.intLeft = intLeft;
    }


    public double left(Pereche subinterval, double punct){
        if( punct <= subinterval.getA())
            return 1.0;
        else
        if( punct >= subinterval.getB())
            return 0.0;
        else
        //if((subinterval.getA() < punct) && (punct < subinterval.getB()))
            return  (punct - subinterval.getB())/(subinterval.getA() - subinterval.getB());
    }
    public double right(Pereche subinterval, double punct){
        if( punct <= subinterval.getA())
            return 0.0;
        else
        if( punct >= subinterval.getB())
            return 1.0;
        else
            //if((subinterval.getA() < punct) && (subinterval < interval.getB()))
            return  (punct - subinterval.getA())/(subinterval.getB() - subinterval.getA()) ;
    }
    public double regular(Pereche subintervalSt, Pereche subintervalDr, double punct){
        if( punct <= subintervalSt.getA() || punct >= subintervalDr.getB())
            return 0.0;
        else
        if( punct >= subintervalSt.getB() && punct <= subintervalDr.getA())
            return 1.0;
        else
        if( punct >= subintervalSt.getA() && punct <= subintervalSt.getB())
            return  (punct - subintervalSt.getA())/(subintervalSt.getB() - subintervalSt.getA());
        else
            return (punct - subintervalDr.getB())/(subintervalDr.getA() - subintervalDr.getB());
    }
    public List<Double> trapez(double val)
    {
        List<Double> list = new ArrayList();
        list.add(left(intLeft,val));
        list.add(regular(intRegular1,intRegular2,val));
        list.add(right(intRight,val));
        return list;

    }

    private double maximu(double a, double b) {
        if(a >= b) return a;
        return b;
    }
    private double minim2(double a, double b){
        if( a<=b ) return a;
        return b;
    }

    private double minim(double a, double b, double c) {
        if (a <= b && a <= c) return a;
        if (b <= a && b <= c) return b;
        return c;
    }


}
