package com.maikw.CPE200ProjectCAREN;

public class UnitFactory {
    public static Antibody createAntibody(String name, String type){
        String g = GeneticCodeManager.getAsString("geneticcodes/sampleteam/working/sampleteam_w0.txt");
        return new Antibody(name, type, g);
    }

    public static Virus createVirus(String name, String type){
        String g = GeneticCodeManager.getAsString("geneticcodes/sampleteam/working/sampleteam_w0.txt");
        return new Virus(name, type, g);
    }
}
