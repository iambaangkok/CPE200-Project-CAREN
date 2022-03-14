package com.maikw.CPE200ProjectCAREN;

public class Inventory {

    protected int meleeCount;
    protected int rangedCount;
    protected int aoeCount;

    public Inventory(){
        this.meleeCount = 1;
        this.rangedCount = 0;
        this.aoeCount = 0;
    }

    public boolean canPickup(String type){
        return switch (type) {
            case "melee" -> meleeCount > 0;
            case "ranged" -> rangedCount > 0;
            case "aoe" -> aoeCount > 0;
            default -> false;
        };
    }

    public void decreaseMeleeCount() {
        this.meleeCount--;
    }

    public void increaseMeleeCount() {
        this.meleeCount++;
    }

    public void decreaseRangedCount() {
        this.rangedCount--;
    }

    public void increaseRangedCount() {
        this.rangedCount++;
    }

    public void decreaseAoeCount() {
        this.aoeCount--;
    }

    public void increaseAoeCount() {
        this.aoeCount++;
    }

    public Integer getMeleeCount() {
        return meleeCount;
    }

    public Integer getRangedCount() {
        return rangedCount;
    }

    public Integer getAoeCount() {
        return aoeCount;
    }
}
