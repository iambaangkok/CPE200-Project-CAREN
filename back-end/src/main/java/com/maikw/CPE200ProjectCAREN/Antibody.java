package com.maikw.CPE200ProjectCAREN;

import java.util.List;

public class Antibody extends Unit{
    public Antibody(String name, String type, String geneticCode) {
        super(name, type, geneticCode);
        this.unitClass = "antibody";
    }

    public void virusToSpawn(List<Virus> q){
        Virus reborn = UnitFactory.createVirus(this.getType());
        this.area.removeAntibody(this);
//        this.area.addVirus(reborn);
        q.add(reborn);
        reborn.setPositionX(this.getPositionX());
        reborn.setPositionY(this.getPositionY());

    }
    
}
