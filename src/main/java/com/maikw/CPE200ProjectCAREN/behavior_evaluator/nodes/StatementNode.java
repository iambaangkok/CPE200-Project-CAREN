package com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes;

public class StatementNode implements Node {

    protected Node statement = null;

    StatementNode(Node statement){
        this.statement = statement;
    }

    @Override
    public double evaluate() {
        statement.evaluate();
        return 0;
    }
    
    
}
