package com.maikw.CPE200ProjectCAREN.behavior_evaluator;


import com.maikw.CPE200ProjectCAREN.GeneticCodeManager;
import com.maikw.CPE200ProjectCAREN.Unit;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes.Node;

import org.junit.jupiter.api.Test;

public class BehaviorEvaluatorTest {

    @Test
    public void validGeneticCodeTest_1(){
        BehaviorEvaluator be = new BehaviorEvaluator(
            GeneticCodeManager.getAsString("geneticcodes/sampleteam/working/sampleteam_w0.txt"),
            new Unit("")
            );
        try{
            Node programNode = be.parseProgram();
        }catch(SyntaxError e){
            System.out.println(e.getMessage());
        }
        
    }

    public static void main(String[] args) {
        BehaviorEvaluator be = new BehaviorEvaluator(
            GeneticCodeManager.getAsString("geneticcodes/sampleteam/working/sampleteam_w0.txt"),
            new Unit("")
            );
        try{
            Node programNode = be.parseProgram();
        }catch(SyntaxError e){
            System.out.println(e.getMessage());
        }
    }

}
