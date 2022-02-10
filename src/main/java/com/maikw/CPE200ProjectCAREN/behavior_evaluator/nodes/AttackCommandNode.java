package com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes;

import com.maikw.CPE200ProjectCAREN.Unit;

public class AttackCommandNode implements Node {

    protected String direction;
    protected Unit unit;

    AttackCommandNode(String direction, Unit unit){
        this.direction = direction;
        this.unit = unit;
    }

    @Override
    public double evaluate() {
        unit.attack(direction);
        return 0;
    }
}
