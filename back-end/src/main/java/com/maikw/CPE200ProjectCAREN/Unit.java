package com.maikw.CPE200ProjectCAREN;

import java.util.HashMap;
import java.util.Map;

import com.maikw.CPE200ProjectCAREN.behavior_evaluator.BehaviorEvaluator;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.SyntaxError;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes.Node;

public class Unit {

    protected int maxHealth = 100;
    protected int currentHealth = 100;
    protected int moveCost = 0;
    protected int attackDamage = 0;
    protected double attackRange = 0.0;
    protected int lifeSteal = 10;
    protected String type = "";
    protected String name;
    protected Map<String, Double> variables;
    protected Node programNode;

    public Unit(String name, String type){
        variables = new HashMap<>();
        this.name = name;
        this.type = type;
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
        return 7;
    }

    public boolean isAlive(){
        return currentHealth <= 0;
    }

    public Map<String, Double> getVariables(){
        return variables;
    }
}
