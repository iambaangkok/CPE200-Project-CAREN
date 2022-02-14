package com.maikw.CPE200ProjectCAREN;

import java.util.Map;

public class Unit {
    protected int maxHealth = 0;
    protected int currentHealth = 0;
    protected int moveCost = 0;
    protected int attackDamage = 0;
    protected double attackRange = 0.0;
    protected int lifeSteal = 0;
    protected Map<String, Integer> variables = null;
    protected String type = "";

    public void move(String direction){

    }

    public void sense(){

    }

    public boolean isAlive(){
        return currentHealth <= 0;
    }
    
    public void attack(Unit target){
        
    }
}
