package com.maikw.CPE200ProjectCAREN;

import java.util.HashMap;
import java.util.Map;

import com.maikw.CPE200ProjectCAREN.behavior_evaluator.BehaviorEvaluator;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.SyntaxError;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes.Node;

public class Unit {

    protected double positionX = 0.0;
    protected double positionY = 0.0;
    protected int maxHealth = 100;
    protected int currentHealth = 100;
    protected int moveCost = 20;
    protected int attackDamage = 0;
    protected double detectRange = 0.0;
    protected double attackRange = 0.0;
    protected double dangerRange = 0.0;
    protected int lifeSteal = 10;
    protected String type = "";
    protected String name;
    protected Map<String, Double> variables;
    protected Node programNode;
    protected Area area;

    public Unit(String name, String type){
        variables = new HashMap<>();
        this.name = name;
        this.type = type;
        this.detectRange = 40;
        this.dangerRange = 5;
        if(type.equals("melee")){
            this.attackDamage = 20;
            this.attackRange = 10;
        }else if(type.equals("ranged")){
            this.attackDamage = 20;
            this.attackRange = 30;
        }else if(type.equals("aoe")){
            this.attackDamage = 15;
            this.attackRange = 10;
        }
        BehaviorEvaluator be = new BehaviorEvaluator("",this);
        try{
            programNode = be.parseProgram();
        }catch(SyntaxError e){
            System.out.println(e.getMessage());
        }
    }

    public void move(String direction){
        System.out.println("Unit " + name + " moved " + direction);
    }

    public void attack(String direction){
        System.out.println("Unit " + name + " attacked " + direction);
    }

    public void attack(Unit target){
        if(target.currentHealth <= this.attackDamage){
            target.currentHealth = 0;
        }else{
            target.currentHealth -= this.attackDamage;
        }
        System.out.println("Unit " + target.name + " current hp = " + target.currentHealth);
    }    

    public int sense(String mode, String direction){
        System.out.println("Unit " + name + " sensed " + mode + " " + direction);
        int directionValue = directionValue(direction);
        switch (mode) {
            case "virus" -> {
                double min = Integer.MAX_VALUE;
                for (Virus v : area.getViruses()) {
                    double range = range(this, v);
                    if (this.detectRange < range) {
                    } else {
                        if (range < min) min = range;
                    }
                }
                if (min == Integer.MAX_VALUE) {
                    return 0;
                } else if (min <= dangerRange) {
                    return 10 + directionValue;
                } else if (min <= attackRange) {
                    return 20 + directionValue;
                } else if (min <= detectRange) {
                    return 30 + directionValue;
                }
            }
            case "antibody" -> {
                double min = Integer.MAX_VALUE;
                for (Antibody a : area.getAntibodies()) {
                    double range = range(this, v);
                    if (this.detectRange < range) {
                    } else {
                        if (range < min) min = range;
                    }
                }
                if (min == Integer.MAX_VALUE) {
                    return 0;
                } else if (min <= dangerRange) {
                    return 10 + directionValue;
                } else if (min <= attackRange) {
                    return 20 + directionValue;
                } else if (min <= detectRange) {
                    return 30 + directionValue;
                }
            }
            case "nearby" -> {
                double min = Integer.MAX_VALUE;
                for (Unit u : area.getUnits()) {
                    double range = range(this, v);
                    if (this.detectRange < range) {
                    } else {
                        if (range < min) min = range;
                    }
                }
                if (min == Integer.MAX_VALUE) {
                    return 0;
                } else if (min <= dangerRange) {
                    return 10 + directionValue;
                } else if (min <= attackRange) {
                    return 20 + directionValue;
                } else if (min <= detectRange) {
                    return 30 + directionValue;
                }
            }
        }
        return 0;
    }

    public static double range(Unit a, Unit b){
        return Math.sqrt(Math.pow((a.positionX - b.positionX),2) + Math.pow((a.positionY - b.positionY),2));
    }

    public static int directionValue(String direction){
        return switch (direction) {
            case "up" -> 1;
            case "upright" -> 2;
            case "right" -> 3;
            case "downright" -> 4;
            case "down" -> 5;
            case "downleft" -> 6;
            case "left" -> 7;
            case "upleft" -> 8;
            default -> 0;
        };
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public Area getArea() {
        return area;
    }

    public boolean isAlive(){
        return currentHealth <= 0;
    }

    public Map<String, Double> getVariables(){
        return variables;
    }


    public void evaluate(){
        programNode.evaluate();
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMoveCost() {
        return moveCost;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public double getDetectRange() {
        return detectRange;
    }

    public double getDangerRange() {
        return dangerRange;
    }

    public double getAttackRange() {
        return attackRange;
    }

    public int getLifeSteal() {
        return lifeSteal;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
