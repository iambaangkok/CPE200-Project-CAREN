package com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes;

import java.util.ArrayList;
import java.util.List;

public class ProgramNode implements Node {

    protected List<Node> statements;

    public ProgramNode(){
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
    

    @Override
    public void print(int depth){
        for(int i = 0 ; i < depth; ++i){
            System.out.print("   ");
        }
        System.out.print(" |---Program ");
        for(Node stm : statements){
            System.out.println();
            stm.print(depth+1);
        }
    }
}
