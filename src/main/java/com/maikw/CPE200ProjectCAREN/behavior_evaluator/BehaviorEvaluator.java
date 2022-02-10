package com.maikw.CPE200ProjectCAREN.behavior_evaluator;

import java.util.Stack;

import com.maikw.CPE200ProjectCAREN.Unit;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes.Node;

public class BehaviorEvaluator{
    protected Tokenizer tkz;
    protected NodeFactory factory;
    protected Unit unit;

    public BehaviorEvaluator(String src, Unit unit) {
        try{
            this.tkz = new Tokenizer(src);
            factory = NodeFactory.instance();
            this.unit = unit;
        }catch(SyntaxError e){
            System.out.println(e.getMessage());
        }
    }
    
    public Node parseProgram(){
        
        Stack<Node> currentBlock = new Stack<>();
        Node mainProgramNode = factory.createProgramNode();
        
        currentBlock.add(mainProgramNode);

        while(tkz.peek() != null){
            if(tkz.peek().matches(Regex.S_RESERVEDWORD)){
                
            }
        }


        return mainProgramNode;
    }
}