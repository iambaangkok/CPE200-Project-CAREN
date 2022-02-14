package com.maikw.CPE200ProjectCAREN;

import java.util.HashMap;
import java.util.Map;

import com.maikw.CPE200ProjectCAREN.behavior_evaluator.BehaviorEvaluator;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.SyntaxError;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes.Node;

public class Unit {

    protected String name;
    protected Map<String, Double> variables;
    protected Node programNode;

    public Unit(String name){
        variables = new HashMap<>();
        this.name = name;
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

    public int sense(String mode, String direction){
        System.out.println("Unit " + name + " sensed " + mode + " " + direction);
        return 7;
    }

    public Map<String, Double> getVariables(){
        return variables;
    }
}
