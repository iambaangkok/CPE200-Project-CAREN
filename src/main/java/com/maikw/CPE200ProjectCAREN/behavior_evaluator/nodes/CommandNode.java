package com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes;

public class CommandNode implements Node {

    protected Node commandNode = null;

    CommandNode(Node commandNode){
        this.commandNode = commandNode;
    }

    @Override
    public double evaluate() {
        commandNode.evaluate();
        return 0;
    }
    
    
}
