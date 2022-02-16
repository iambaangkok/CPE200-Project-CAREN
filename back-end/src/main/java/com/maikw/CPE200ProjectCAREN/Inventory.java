package com.maikw.CPE200ProjectCAREN;

public class Inventory {

    protected Integer meleeCount = 0 ;
    protected Integer rangedCount  = 0;
    protected Integer aoeCount = 0 ;



    public Inventory(Integer meleeCount, Integer rangedCount ,Integer aoeCount){

        this.meleeCount += meleeCount;
        this.rangedCount += rangedCount;
        this.aoeCount += aoeCount;
    }


    public void setMeleeCount(Integer meleeCount) {
        this.meleeCount += meleeCount;
    }

    public void setRangedCount(Integer rangedCount) {
        this.rangedCount += rangedCount;
    }

    public void setAoeCount(Integer aoeCount) {
        this.aoeCount += aoeCount;
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
