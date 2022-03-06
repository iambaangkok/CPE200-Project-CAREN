package com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes;

import java.util.Random;

public class RandomNumberNode extends VariableNode{
    protected Random random = null;

    public RandomNumberNode(){
        random = new Random();
        identifier = "random";
    }

    @Override
    public double evaluate() {
        return random.nextInt()%100;
    }

    @Override
    public void assignValue(double value){
        // no-op
    }
}
