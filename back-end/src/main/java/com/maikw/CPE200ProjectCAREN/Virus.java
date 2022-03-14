package com.maikw.CPE200ProjectCAREN;

import java.util.Random;

public class Virus extends Unit{
    public Virus(String name, String type, String geneticCode) {
        super(name, type, geneticCode);
        super.unitClass = "virus";
        Random r = new Random();
        double valX = (-100.0) + (100.0 - (-100.0)) * r.nextDouble();
        double valY = (-100.0) + (100.0 - (-100.0)) * r.nextDouble();
        this.positionX = (double) (Math.round(valX*10.0)/10.0);
        this.positionY = (double) (Math.round(valY*10.0)/10.0);
    }

    public int creditReward(){
        return 50;
    }
    
}
