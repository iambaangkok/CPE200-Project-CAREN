package com.maikw.CPE200ProjectCAREN;

public class Shop {
    protected int maxCredit;
    protected int minCredit;
    protected int currentCredit;
    protected int meleePrice;
    protected int rangedPrice;
    protected int aoePrice;
    protected Inventory inventory;

    public Shop() {
        this.maxCredit = 9999;
        this.minCredit = 0;
        this.currentCredit = 3500;
        this.meleePrice = 100;
        this.rangedPrice = 200;
        this.aoePrice = 250;
    }

    public void buyMelee(){
        if(canBuy("melee")){
            inventory.increaseMeleeCount();
            currentCredit -= meleePrice;
        }else{
            System.out.println("You have no enough credit.");
        }
    }

    public void buyRanged(){
        if(canBuy("ranged")){
            inventory.increaseRangedCount();
            currentCredit -= rangedPrice;
        }else{
            System.out.println("You have no enough credit.");
        }
    }

    public void buyAoe(){
        if(canBuy("aoe")){
            inventory.increaseAoeCount();
            currentCredit -= aoePrice;
        }else{
            System.out.println("You have no enough credit.");
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
