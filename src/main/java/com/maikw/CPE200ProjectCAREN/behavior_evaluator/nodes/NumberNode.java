package com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes;

public class NumberNode implements Node{
    protected double number;

    public NumberNode(double number){
        this.number = number;
    }

    @Override
    public double evaluate() {
        return number;
    }
}
