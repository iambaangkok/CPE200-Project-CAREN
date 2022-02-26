package com.maikw.CPE200ProjectCAREN;

public class Antibody extends Unit{
    public Antibody(String name, String type, String geneticCode) {
        super(name, type, geneticCode);
        this.unitClass = "antibody";
    }

    public Virus virusToSpawn(){
        Virus reborn = UnitFactory.createVirus(this.getType());
        this.area.removeAntibody(this);
        this.area.addVirus(reborn);
        return reborn;
    }
    
}
