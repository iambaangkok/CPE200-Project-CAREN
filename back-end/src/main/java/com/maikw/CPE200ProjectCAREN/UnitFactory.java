package com.maikw.CPE200ProjectCAREN;

public class UnitFactory {
    private static int count = 0;

    public static Antibody createAntibody(String type){
//        String g = GeneticCodeManager.getAsString("genetic-codes/maikoiwang/working/maikoiwang_w1.txt");
        String g = GeneticCodeManager.getAsString("genetic-codes/sampleteam/working/sampleteam_w0.txt");

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

    public static Antibody createAntibody(String type, GeneticCodeManager gm){
        String g = GeneticCodeManager.getAsString("genetic-codes/sampleteam/working/sampleteam_w0.txt");

        Antibody ab;
        switch (type) {
            case "melee" -> {
                if(gm.getAntibodyMelee().length() > 0)
                    g = gm.getAntibodyMelee();
                ab = new Antibody("antibody_melee" + count, type, g);
            }
            case "ranged" -> {
                if(gm.getAntibodyRanged().length() > 0)
                    g = gm.getAntibodyRanged();
                ab = new Antibody("antibody_ranged" + count, type, g);
            }
            case "aoe" -> {
                if(gm.getAntibodyAOE().length() > 0)
                    g = gm.getAntibodyAOE();
                ab =  new Antibody("antibody_aoe" + count, type, g);
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
        count++;
        return ab;
    }

    public static Virus createVirus(String type){
//        String g = GeneticCodeManager.getAsString("genetic-codes/maikoiwang/working/maikoiwang_w1.txt");
        String g = GeneticCodeManager.getAsString("genetic-codes/sampleteam/working/sampleteam_w1.txt");
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

    public static Unit createDummy(String type){
        String g = GeneticCodeManager.getAsString("genetic-codes/sampleteam/working/sampleteam_w1.txt");
        Unit u;
        switch (type) {
            case "melee" -> {
                u = new Unit("Unit_melee", type, g);
            }
            case "ranged" -> {
                u = new Unit("Unit_ranged", type, g);
            }
            case "aoe" -> {
                u =  new Unit("Unit_aoe", type, g);
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
        u.setPositionX(0); u.setPositionY(0);
        return u;
    }
}
