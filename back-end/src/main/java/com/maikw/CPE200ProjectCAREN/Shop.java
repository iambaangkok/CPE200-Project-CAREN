package com.maikw.CPE200ProjectCAREN;

public class Shop {
    protected int maxCredit;
    protected int minCredit;
    protected int currentCredit;
    protected int meleePrice;
    protected int rangedPrice;
    protected int aoePrice;
    protected Inventory inventory;
    private final boolean DEBUG = true;

    public Shop() {
        this.maxCredit = 9999;
        this.minCredit = 0;
        this.currentCredit = Config.startCredit;
        this.meleePrice = Config.meleePrice;
        this.rangedPrice = Config.rangedPrice;
        this.aoePrice = Config.aoePrice;
    }

    public void buyMelee(){
        if(canBuy("melee")){
            inventory.increaseMeleeCount();
            currentCredit -= meleePrice;
        }else{
            if(DEBUG) System.out.println("You have no enough credit.");
        }
    }

    public void buyRanged(){
        if(canBuy("ranged")){
            inventory.increaseRangedCount();
            currentCredit -= rangedPrice;
        }else{
            if(DEBUG) System.out.println("You have no enough credit.");
        }
    }

    public void buyAoe(){
        if(canBuy("aoe")){
            inventory.increaseAoeCount();
            currentCredit -= aoePrice;
        }else{
            if(DEBUG) System.out.println("You have no enough credit.");
        }
    }

    public boolean canBuy(String type){
        return switch (type) {
            case "melee" -> currentCredit >= meleePrice;
            case "ranged" -> currentCredit >= rangedPrice;
            case "aoe" -> currentCredit >= aoePrice;
            default -> false;
        };
    }

    public int getMaxCredit() {
        return maxCredit;
    }

    public int getCurrentCredit() {
        return currentCredit;
    }

    public int getMeleePrice() {
        return meleePrice;
    }

    public int getRangedPrice() {
        return rangedPrice;
    }

    public int getAoePrice() {
        return aoePrice;
    }

    public int getMinCredit() {
        return minCredit;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    public void setCurrentCredit(int currentCredit) {
        this.currentCredit = currentCredit;
    }
}
