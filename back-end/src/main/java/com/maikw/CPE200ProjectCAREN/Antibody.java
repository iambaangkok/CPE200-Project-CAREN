package com.maikw.CPE200ProjectCAREN;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(value = { "programNode", "variables", "area" })
public class Antibody extends Unit{
    public Antibody(String name, String type, String geneticCode) {
        super(name, type, geneticCode);
        this.unitClass = "antibody";

        switch (type) {
            case "melee" -> {
                this.attackDamage = 30;
                this.attackRange = 10;
                this.moveSpeed = 3;
            }
            case "ranged" -> {
                this.attackDamage = 30;
                this.attackRange = 30;
                this.moveSpeed = 2;
            }
            case "aoe" -> {
                this.attackDamage = 25;
                this.attackRange = 20;
                this.aoeRadius = 5;
                this.moveSpeed = 1;
            }
        }
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
