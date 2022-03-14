package com.maikw.CPE200ProjectCAREN.behavior_evaluator;


import java.io.FileReader;
import java.util.Scanner;

import com.maikw.CPE200ProjectCAREN.GeneticCodeManager;
import com.maikw.CPE200ProjectCAREN.Unit;

import org.junit.jupiter.api.Test;

public class BehaviorEvaluatorTest {

    public static Exception E_NULL = new NullPointerException();
    public static Exception E_SYNTAX = new SyntaxError();

    @Test
    public void valid_expressions(){
        String filePath = "geneticcodes/maikoiwang/working/maikoiwang_w_expressions_0.txt";
        String gCode = GeneticCodeManager.getAsString(filePath);
        try{
            Unit unit = new Unit("gCode_testUnit", "melee", gCode);
            unit.programNode.print(0);
        }catch(Exception e){

        }
    }
    
    @Test
    public void invalid_expressions(){
        String filePath = "geneticcodes/maikoiwang/working/maikoiwang_f_expressions_0.txt";
        try{
            FileReader fr = new FileReader(filePath);
            Scanner s = new Scanner(fr);
            while(s.hasNextLine()){
                String nextLine = s.nextLine();
                System.out.print(nextLine + "   ");
                Unit unit = new Unit("gCode_testUnit", "melee", nextLine);
                //unit.programNode.print(0);
                System.out.println();
            }
            s.close();
        }catch(Exception e){
            System.out.println("invalid_expressions crashed");
            e.printStackTrace();
        }
    }

    @Test
    public void sample_gc(){
        String filePath = "back-end/geneticcodes/sampleteam/working/sampleteam_w0.txt";
        String gCode = GeneticCodeManager.getAsString(filePath);
        Unit unit = new Unit("gCode_testUnit", "melee", gCode);
        unit.programNode.print(0);
        System.out.println();
    }

    public static void main(String[] args) {
        BehaviorEvaluatorTest betest = new BehaviorEvaluatorTest();
        //betest.valid_expressions();
        //betest.invalid_expressions();
        betest.sample_gc();
    }
    
}
