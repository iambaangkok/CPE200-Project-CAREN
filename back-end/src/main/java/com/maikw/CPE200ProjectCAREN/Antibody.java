package com.maikw.CPE200ProjectCAREN;

public class Antibody extends Unit{
    public Antibody(String name, String type, String geneticCode) {
        super(name, type, geneticCode);
        this.unitClass = "antibody";
    }

    @Override
    public void takeDamage(int dmg){
        super.takeDamage(dmg);
        if(this.getCurrentHealth() <= 0) virusToSpawn();
    }

    public void virusToSpawn(){
        Virus reborn = UnitFactory.createVirus(this.getType());
        this.area.removeAntibody(this);
        this.area.addVirus(reborn);
        reborn.setPositionX(this.getPositionX());
        reborn.setPositionY(this.getPositionY());
    }
    
}
