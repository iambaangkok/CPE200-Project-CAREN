package com.maikw.CPE200ProjectCAREN;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Random;
@JsonIgnoreProperties(value = { "programNode", "variables", "area" })
public class Virus extends Unit{
    public Virus(String name, String type, String geneticCode) {
        super(name, type, geneticCode);
        super.unitClass = "virus";
        Unit dummy = UnitFactory.createDummy("melee");
        Random r = new Random();
        double valX = (-100.0) + (100.0 - (-100.0)) * r.nextDouble();
        double valY = (-100.0) + (100.0 - (-100.0)) * r.nextDouble();
        while(range(dummy, this) > 100){
            valX = (-100.0) + (100.0 - (-100.0)) * r.nextDouble();
            valY = (-100.0) + (100.0 - (-100.0)) * r.nextDouble();
        }
        this.positionX = (double) (Math.round(valX*10.0)/10.0);
        this.positionY = (double) (Math.round(valY*10.0)/10.0);
    }

    public int creditReward(){
        return 50;
    }
    
}
