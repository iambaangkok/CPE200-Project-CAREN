package com.maikw.CPE200ProjectCAREN;

public class Antibody extends Unit{
    public Antibody(String name, String type, String geneticCode) {
        super(name, type, geneticCode);
        super.unitClass = "Antibody";
    }

    public Virus virusToSpawn(String name, String type, String geneticCode){
        return new Virus(name, type, geneticCode);
    }
    
}
