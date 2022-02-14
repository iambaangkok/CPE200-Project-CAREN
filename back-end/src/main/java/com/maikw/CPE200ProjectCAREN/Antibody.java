package com.maikw.CPE200ProjectCAREN;

public class Antibody extends Unit{
    public Antibody(String name, String type) {
        super(name, type);
    }


    public Virus virusToSpawn(String name, String type){
        return new Virus(name, type);
    }
    
}
