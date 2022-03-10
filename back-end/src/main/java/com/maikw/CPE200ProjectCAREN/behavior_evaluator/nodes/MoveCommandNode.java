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
        if(!unit.getDidActionCommand()){
            unit.move(direction);
            unit.setDidActionCommand(true);
        }
        return 0;
    }

    @Override
    public void print(int depth){
        for(int i = 0 ; i < depth; ++i){
            System.out.print("   ");
        }
        System.out.println(" |---Move " + direction);
    }
}
