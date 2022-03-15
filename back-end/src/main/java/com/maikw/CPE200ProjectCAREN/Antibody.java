package com.maikw.CPE200ProjectCAREN;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(value = { "programNode", "variables", "area" })
public class Antibody extends Unit{
    public Antibody(String name, String type, String geneticCode) {
        super(name, type, geneticCode);
        this.unitClass = "antibody";
        this.maxHealth = Config.antibodyHealth;
        this.currentHealth = maxHealth;

        switch (type) {
            case "melee" -> {
                this.attackDamage = Config.antibodyMeleeDamage;
                this.attackRange = Config.meleeAttackRange;
                this.moveSpeed = Config.meleeMoveSpeed;
            }
            case "ranged" -> {
                this.attackDamage = Config.antibodyRangedDamage;
                this.attackRange = Config.rangedAttackRange;
                this.moveSpeed = Config.rangedMoveSpeed;
            }
            case "aoe" -> {
                this.attackDamage = Config.antibodyAoeDamage;
                this.attackRange = Config.aoeAttackRange;
                this.aoeRadius = 5;
                this.moveSpeed = Config.aoeMoveSpeed;
            }
        }
    }

    public void virusToSpawn(List<Virus> q){
        Virus reborn = UnitFactory.createVirus(this.getType());
        this.area.removeAntibody(this);
        q.add(reborn);
        reborn.setPositionX(this.getPositionX());
        reborn.setPositionY(this.getPositionY());

    }
    
}
