package com.maikw.CPE200ProjectCAREN;

public class UnitFactory {
    public Antibody createAntibody(){
        return new Antibody();
    }

    public Virus createVirus(){
        return new Virus();
    }
}
