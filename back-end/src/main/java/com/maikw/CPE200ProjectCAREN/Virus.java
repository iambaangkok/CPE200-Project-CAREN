package com.maikw.CPE200ProjectCAREN;

import java.util.Random;

public class Virus extends Unit{
    public Virus(String name, String type, String geneticCode) {
        super(name, type, geneticCode);
        super.unitClass = "virus";
        Random r = new Random();
        this.positionX = (-100.0) + (100.0 - (-100.0)) * r.nextDouble();
        this.positionY = (-100.0) + (100.0 - (-100.0)) * r.nextDouble();
    }

    public int creditReward(){
        return 50;
    }
    
}
