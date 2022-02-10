package com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes;

public class AssignmentStatementNode implements Node{
    
    protected VariableNode variableNode;
    protected Node expressionNode;

    AssignmentStatementNode(VariableNode variableNode, Node expressionNode){
        this.variableNode = variableNode;
        this.expressionNode = expressionNode;
    }

    @Override
    public double evaluate() {
        variableNode.assignValue(expressionNode.evaluate());
        return 0;
    }
}
