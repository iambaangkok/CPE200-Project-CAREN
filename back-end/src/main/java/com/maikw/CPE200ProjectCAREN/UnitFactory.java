package com.maikw.CPE200ProjectCAREN;

public class UnitFactory {
    public static Antibody createAntibody(String name, String type){
        return new Antibody(name, type);
    }

    public static Virus createVirus(String name, String type){
        return new Virus(name, type);
    }
}
