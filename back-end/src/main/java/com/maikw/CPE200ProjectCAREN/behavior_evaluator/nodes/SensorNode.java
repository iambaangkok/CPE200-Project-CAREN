package com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes;

import com.maikw.CPE200ProjectCAREN.Unit;

public class SensorNode implements Node {
    protected String mode;
    protected String direction;
    protected Unit unit;

    public SensorNode(String mode, String direction, Unit unit) {
        this.mode = mode;
        this.direction = direction;
        this.unit = unit;
    }

    public double evaluate(){
        return unit.sense(mode, direction);
    }

    @Override
    public void print(int depth){
        for(int i = 0 ; i < depth; ++i){
            System.out.print("   ");
        }
        System.out.print(" m " + mode + " d " + direction);
    }
}
