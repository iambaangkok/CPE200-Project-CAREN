package com.maikw.CPE200ProjectCAREN;

public class UnitFactory {
    private static int count = 0;

    public static Antibody createAntibody(String type){
        String g = GeneticCodeManager.getAsString("geneticcodes/maikoiwang/working/maikoiwang_w1.txt");
        Antibody ab;
        switch (type) {
            case "melee" -> {
                ab = new Antibody("antibody_melee" + count, type, g);
            }
            case "ranged" -> {
                ab = new Antibody("antibody_ranged" + count, type, g);
            }
            case "aoe" -> {
                ab =  new Antibody("antibody_aoe" + count, type, g);
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
        count++;
        return ab;
    }

    public static Virus createVirus(String type){
        String g = GeneticCodeManager.getAsString("geneticcodes/maikoiwang/working/maikoiwang_w1.txt");
        Virus v;
        switch (type) {
            case "melee" -> {
                v = new Virus("virus_melee" + count, type, g);
            }
            case "ranged" -> {
                v = new Virus("virus_ranged" + count, type, g);
            }
            case "aoe" -> {
                v =  new Virus("virus_aoe" + count, type, g);
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
        count++;
        return v;
    }
}
