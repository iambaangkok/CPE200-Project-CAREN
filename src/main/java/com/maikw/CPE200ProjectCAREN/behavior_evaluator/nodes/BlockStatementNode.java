package com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes;

import java.util.ArrayList;
import java.util.List;

public class BlockStatementNode implements Node {

    protected List<Node> statements;

    BlockStatementNode(){
        statements = new ArrayList<>();
    }

    /** Add {@statementNode} to the list of statements that needs to be executed
     * 
     * @param statementNode the statement to be added
     */
    public void addStatement(Node statementNode){
        statements.add(statementNode);
    }

    @Override
    public double evaluate() {
        for(Node statement : statements){
            statement.evaluate();
        }
        return 0;
    }
    
}
