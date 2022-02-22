package com.maikw.CPE200ProjectCAREN;

public class Virus extends Unit{
    public Virus(String name, String type, String geneticCode) {
        super(name, type, geneticCode);
        super.unitClass = "Virus";
    }

    public int creditReward(){
        return 50;
    }
    
}
