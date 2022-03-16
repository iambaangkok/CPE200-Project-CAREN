package com.maikw.CPE200ProjectCAREN;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Random;
@JsonIgnoreProperties(value = { "programNode", "variables", "area" })
public class Virus extends Unit{
    public Virus(String name, String type, String geneticCode) {
        super(name, type, geneticCode);
        this.unitClass = "virus";

        switch (type) {
            case "melee" -> {
                this.maxHealth = Config.virusMeleeHealth;
                this.attackDamage = Config.virusMeleeDamage;
                this.attackRange = Config.meleeAttackRange;
                this.moveSpeed = Config.meleeMoveSpeed;
            }
            case "ranged" -> {
                this.maxHealth = Config.virusRangedHealth;
                this.attackDamage = Config.virusRangedDamage;
                this.attackRange = Config.rangedAttackRange;
                this.moveSpeed = Config.rangedMoveSpeed;
            }
            case "aoe" -> {
                this.maxHealth = Config.virusAoeHealth;
                this.attackDamage = Config.virusAoeDamage;
                this.attackRange = Config.aoeAttackRange;
                this.aoeRadius = 5;
                this.moveSpeed = Config.aoeMoveSpeed;
            }
        }
        this.currentHealth = maxHealth;

        Unit dummy = UnitFactory.createDummy("melee");
        Random r = new Random();
        double valX = (-100.0) + (100.0 - (-100.0)) * r.nextDouble();
        double valY = (-100.0) + (100.0 - (-100.0)) * r.nextDouble();
        this.positionX = (double) (Math.round(valX*10.0)/10.0);
        this.positionY = (double) (Math.round(valY*10.0)/10.0);
        while(range(dummy, this) > 100){
            valX = (-100.0) + (100.0 - (-100.0)) * r.nextDouble();
            valY = (-100.0) + (100.0 - (-100.0)) * r.nextDouble();
            this.positionX = (double) (Math.round(valX*10.0)/10.0);
            this.positionY = (double) (Math.round(valY*10.0)/10.0);
        }
    }

    public int creditReward(){
        return Config.creditReward;
    }

}
