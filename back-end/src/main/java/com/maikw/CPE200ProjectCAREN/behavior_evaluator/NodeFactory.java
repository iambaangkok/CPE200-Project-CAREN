package com.maikw.CPE200ProjectCAREN.behavior_evaluator;

import java.util.Map;

import com.maikw.CPE200ProjectCAREN.Unit;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes.*;

public class NodeFactory {
    
    private static NodeFactory instance;

    private NodeFactory() {}

    public static NodeFactory instance() {
        if (instance == null) {
            instance = new NodeFactory();
        }
        return instance;
    }

    /**
     * 
     * @return a ProgramNode/BlockStatementNode. it's the same thing
     */
    public ProgramNode createProgramNode(){
        return new ProgramNode();
    }
    /**
     * 
     * @param variableNode
     * @param expressionNode
     * @return an AssignmentStatementNode
     */
    public Node createNode(VariableNode variableNode, Node expressionNode){
        return new AssignmentStatementNode(variableNode, expressionNode);
    }
    /**
     * 
     * @param isAttack
     * @param direction
     * @param unit
     * @return an AttackCommandNode if {@code isAttack} is true. otherwise returns a MoveCommandNode
     */
    public Node createNode(boolean isAttack,String direction, Unit unit){
        if(isAttack)
            return new AttackCommandNode(direction, unit);
        return new MoveCommandNode(direction, unit);
    }
    /**
     * 
     * @param expressionNode
     * @param ifTrueStatementNode
     * @param ifFalseStatementNode
     * @return an IfStatementNode
     */
    public Node createNode(Node expressionNode, Node ifTrueStatementNode, Node ifFalseStatementNode){
        return new IfStatementNode(expressionNode, ifTrueStatementNode, ifFalseStatementNode);
    }
    /**
     * 
     * @param expressionNode
     * @param statementNode
     * @return a WhileStatementNode
     */
    public Node createNode(Node expressionNode, Node statementNode){
        return new WhileStatementNode(expressionNode, statementNode);
    }
    /**
     * 
     * @param value
     * @return a NumberNode
     */
    public Node createNode(double value){
        return new NumberNode(value);
    }
    /**
     * 
     * @param identifier
     * @param variables
     * @return a VariableNode
     */
    public VariableNode createNode(String identifier, Map<String,Double> variables){
        return new VariableNode(identifier,variables);
    }
    /**
     * 
     * @return a RandomNumberNode
     */
    public VariableNode createRandomNumberNode(){
        return new RandomNumberNode();
    }
    /**
     * 
     * @param left
     * @param op
     * @param right
     * @return a BinaryArithmeticNode
     */
    public Node createNode(Node left, String op, Node right){
        return new BinaryArithmeticNode(left, op, right);
    }
    /**
     * 
     * @param mode
     * @param direction
     * @param unit
     * @return a SensorNode
     */
    public Node createNode(String mode, String direction, Unit unit){
        return new SensorNode(mode, direction, unit);
    }
    
}
