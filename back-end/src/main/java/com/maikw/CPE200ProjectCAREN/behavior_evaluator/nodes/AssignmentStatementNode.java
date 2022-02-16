package com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes;

public class AssignmentStatementNode implements Node{
    
    protected VariableNode variableNode;
    protected Node expressionNode;

    public AssignmentStatementNode(VariableNode variableNode, Node expressionNode){
        this.variableNode = variableNode;
        this.expressionNode = expressionNode;
    }

    @Override
    public double evaluate() {
        variableNode.assignValue(expressionNode.evaluate());
        return 0;
    }

    @Override
    public void print(int depth){
        for(int i = 0 ; i < depth; ++i){
            System.out.print("   ");
        }
        System.out.print(" |---Assign ");
        variableNode.print(0);
        System.out.print(" = ");
        expressionNode.print(0);
    }
}
