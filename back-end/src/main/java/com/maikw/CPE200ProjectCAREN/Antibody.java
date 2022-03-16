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
                this.maxHealth = Config.antibodyMeleeHealth;
                this.attackDamage = Config.antibodyMeleeDamage;
                this.attackRange = Config.meleeAttackRange;
                this.moveSpeed = Config.meleeMoveSpeed;
            }
            case "ranged" -> {
                this.maxHealth = Config.antibodyRangedHealth;
                this.attackDamage = Config.antibodyRangedDamage;
                this.attackRange = Config.rangedAttackRange;
                this.moveSpeed = Config.rangedMoveSpeed;
            }
            case "aoe" -> {
                this.maxHealth = Config.antibodyAoeHealth;
                this.attackDamage = Config.antibodyAoeDamage;
                this.attackRange = Config.aoeAttackRange;
                this.aoeRadius = 5;
                this.moveSpeed = Config.aoeMoveSpeed;
            }
        }
        this.currentHealth = maxHealth;
    }

    public void virusToSpawn(List<Virus> q){
        Virus reborn = UnitFactory.createVirus(this.getType());
        this.area.removeAntibody(this);
        q.add(reborn);
        reborn.setPositionX(this.getPositionX());
        reborn.setPositionY(this.getPositionY());

    }
    
}
