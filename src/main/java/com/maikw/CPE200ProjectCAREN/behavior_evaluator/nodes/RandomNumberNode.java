package com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes;

import java.util.Random;

public class RandomNumberNode implements Node{
    protected Random random = null;

    RandomNumberNode(double number){
        random = new Random();
    }

    @Override
    public double evaluate() {
        return random.nextDouble()*100;
    }
}
