package com.maikw.CPE200ProjectCAREN;

import com.maikw.CPE200ProjectCAREN.apiclasses.ApiData_GeneticCodeUpload;
import com.maikw.CPE200ProjectCAREN.apiclasses.GameState;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.BehaviorEvaluator;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.SyntaxError;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.UnmatchedParenthesesError;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GeneticCodeManager {

    protected String virusMelee = "";
    protected String virusRanged = "";
    protected String virusAOE = "";
    protected String antibodyMelee = "";
    protected String antibodyRanged = "";
    protected String antibodyAOE = "";



    public GeneticCodeManager(){

    }

    /**
     * Combine the genetic code file in to one single string.
     * @param filePath the path to the specified genetic code
     * @return 
     */
    public static String getAsString(String filePath){
        StringBuilder sb = new StringBuilder("");

        try (FileReader fr = new FileReader(filePath); Scanner s = new Scanner(fr);) {
            while(s.hasNextLine()){
                sb.append(s.nextLine());
                sb.append("\n");
            }
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File not found <- From Genetic Code");
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        } 

        return sb.toString();
    }

    public String getVirusMelee() {
        return virusMelee;
    }

    public String getVirusRanged() {
        return virusRanged;
    }

    public String getVirusAOE() {
        return virusAOE;
    }

    public String getAntibodyMelee() {
        return antibodyMelee;
    }

    public void setAntibodyMelee(String antibodyMelee) {
        this.antibodyMelee = antibodyMelee;
    }

    public String getAntibodyRanged() {
        return antibodyRanged;
    }

    public void setAntibodyRanged(String antibodyRanged) {
        this.antibodyRanged = antibodyRanged;
    }

    public String getAntibodyAOE() {
        return antibodyAOE;
    }

    public void setAntibodyAOE(String antibodyAOE) {
        this.antibodyAOE = antibodyAOE;
    }


}
