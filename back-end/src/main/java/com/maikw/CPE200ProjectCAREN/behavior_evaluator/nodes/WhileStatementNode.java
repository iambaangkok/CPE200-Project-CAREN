package com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes;

public class WhileStatementNode implements Node {

    Node expressionNode;
    Node statementNode;

    public WhileStatementNode(Node expressionNode, Node statementNode) {
        this.expressionNode = expressionNode;
        this.statementNode = statementNode;
    }
    
    @Override
    public double evaluate() {
        for (int limit = 0; limit < 1000 && expressionNode.evaluate() > 0; limit++){
            statementNode.evaluate();
        }

        return 0;
    }

    @Override
    public void print(int depth){
        for(int i = 0 ; i < depth; ++i){
            System.out.print("   ");
        }
        System.out.print(" |---If ");
        expressionNode.print(0);
        statementNode.print(depth+1);
    }
}
