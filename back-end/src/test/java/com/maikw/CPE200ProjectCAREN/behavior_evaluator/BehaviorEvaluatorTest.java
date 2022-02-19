package com.maikw.CPE200ProjectCAREN.behavior_evaluator;


import com.maikw.CPE200ProjectCAREN.Antibody;
import com.maikw.CPE200ProjectCAREN.Area;
import com.maikw.CPE200ProjectCAREN.GeneticCodeManager;
import com.maikw.CPE200ProjectCAREN.Unit;
import com.maikw.CPE200ProjectCAREN.UnitFactory;
import com.maikw.CPE200ProjectCAREN.Virus;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes.Node;

import org.junit.jupiter.api.Test;

public class BehaviorEvaluatorTest {

    // @Test
    // public void validGeneticCodeTest_1(){
    //     BehaviorEvaluator be = new BehaviorEvaluator(
    //         GeneticCodeManager.getAsString("geneticcodes/sampleteam/working/sampleteam_w0.txt"),
    //         new Unit("","")
    //         );
    //     try{
    //         Node programNode = be.parseProgram();
    //         programNode.evaluate();
    //     }catch(SyntaxError e){
    //         System.out.println(e.getMessage());
    //     }
        
    // }

    public static void main(String[] args) {
        BehaviorEvaluator be = new BehaviorEvaluator(
            GeneticCodeManager.getAsString("geneticcodes/sampleteam/working/sampleteam_w0.txt"),
            UnitFactory.createAntibody("melee")
            );
        try{
            Node programNode = be.parseProgram();
            programNode.print(0);
            //programNode.evaluate();
        }catch(SyntaxError e){
            System.out.println(e.getMessage());
        }
    }
    
    // public static void main(String[] args) {
    //     String g = GeneticCodeManager.getAsString("geneticcodes/sampleteam/working/sampleteam_w0.txt");

    //     Antibody a = new Antibody("A","melee",g); a.setPositionX(5.0); a.setPositionY(0.0);
    //     Virus b = new Virus("B","melee",g); b.setPositionX(4.0); b.setPositionY(-1.0);
    //     Virus c = new Virus("C", "melee",g); c.setPositionX(2.0); c.setPositionY(0.0);
    //     Virus d = new Virus("D", "melee",g); d.setPositionX(5.0); d.setPositionY(-10.0);
    //     Area area = new Area("Area1");
    //     area.addAntibody(a); area.addVirus(b); area.addVirus(c); area.addVirus(d);
    //     a.setArea(area); b.setArea(area); c.setArea(area); d.setArea(area);

    //     System.out.println("Angle(a,b) = " + Unit.getAngle(a,b));
    //     System.out.println("Angle(a,c) = " + Unit.getAngle(a,c));
    //     System.out.println("Angle(a,d) = " + Unit.getAngle(a,d));
    //     System.out.println("Sense = " + a.sense("nearby","left"));
    // }

}
