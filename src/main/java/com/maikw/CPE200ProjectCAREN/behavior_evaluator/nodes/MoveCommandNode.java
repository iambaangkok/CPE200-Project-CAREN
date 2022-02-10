package com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes;

import com.maikw.CPE200ProjectCAREN.Unit;

public class MoveCommandNode implements Node {

    protected String direction;
    protected Unit unit;

    public MoveCommandNode(String direction, Unit unit){
        this.direction = direction;
        this.unit = unit;
    }

    @Override
    public double evaluate() {
        unit.move(direction);
        return 0;
    }
}
