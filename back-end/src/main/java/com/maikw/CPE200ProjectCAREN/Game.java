package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.List;

public class Game implements Runnable{
    public String id;
    protected Shop shop ;
    protected Integer state  = 1 ;
    protected Boolean notSpawnedYet;   // เป็นตัวกำหนดว่ายังไม่ได้เริ่มวางตัว
    protected List<Area> areas;
    protected Inventory inventory ;
    protected WaveManager waveManager ;
    protected TimeManager timeManager ;
    protected GeneticCodeManager geneticCodeManager;
    protected List<Antibody> queueAntibobyArea1 ;
    protected List<Antibody> queueAntibobyArea2 ;
    protected List<Antibody> queueAntibobyArea3 ;
    protected List<Virus> queueVirusArea1 ;
    protected List<Virus> queueVirusArea2 ;
    protected List<Virus> queueVirusArea3 ;

    protected String startGameLoopS;
    protected String startGameLoopM;
    protected String startGameLoopF;


    public Game(){
        this.shop = new Shop();
        this.notSpawnedYet = true ;
        this.areas = new ArrayList<Area>();
        this.inventory = new Inventory();
        this.waveManager = new WaveManager();
        this.timeManager = new TimeManager();
        this.queueAntibobyArea1 = new ArrayList<Antibody>();
        this.queueAntibobyArea2 = new ArrayList<Antibody>();
        this.queueAntibobyArea3 = new ArrayList<Antibody>();
        this.queueVirusArea1 = new ArrayList<Virus>();
        this.queueVirusArea2 = new ArrayList<Virus>();
        this.queueVirusArea3 = new ArrayList<Virus>();
        areas.add(new Area("area1", queueVirusArea1));
        areas.add(new Area("area2", queueVirusArea2));
        areas.add(new Area("area3", queueVirusArea3));
        this.geneticCodeManager = new GeneticCodeManager();

        shop.setInventory(inventory);
    }

    public void startGameLoop(){



        waveManager.addVirus();

        while (areas.get(0).antibodies.size() != 0 || areas.get(1).antibodies.size() != 0
                || areas.get(2).antibodies.size() != 0 || notSpawnedYet){
            System.out.println("Game ID = " + id);
            System.out.println(areas.get(0).antibodies.size() + " " + areas.get(1).antibodies.size() + " " +
            areas.get(2).antibodies.size());

            while(timeManager.inputType.equals("pause")) {
                waitState(1);
                System.out.println("pause state");
            }

            waitState(timeManager.timeSate.get(0)); // สปีดของ loop

        // test genAnti 1 ตัว
//            System.out.println(inventory.meleeCount);
//            InventoryController ic = new InventoryController(this);
//            System.out.println(ic.pickupUnit("melee",areas.get(0),0.0,0.0));


//            if(spawn == true){waitState(timeManager.timeSate.get(1)); this.spawn = false;} //timeManager.timeSate.get(1) //คือเวลาที่กำลังจะปล่อยไวรัส

            while (notSpawnedYet && ( areas.get(0).antibodies.size() == 0 || areas.get(1).antibodies.size() == 0 || areas.get(2).antibodies.size() == 0 )){
                System.out.println("You must place at least 1 unit in each area.");
                waitState(1);

                toAddAntiboby();
                toAddViruse();
            }
            notSpawnedYet = false;
            toAddAntiboby();
            toAddViruse();

            if(areas.get(0).viruses.size() == 0 && areas.get(1).viruses.size() == 0
                    && areas.get(2).viruses.size() == 0 ) {

                waveManager.currentWaveCount += 1;

                if (waveManager.currentWaveCount <= waveManager.maxWaveCount) {

                    waitState(timeManager.timeSate.get(4));    //timeManager.timeSate.get(4) // 15 วิ

                    putVirusToArea(0);
                    putVirusToArea(1);
                    putVirusToArea(2);
                    System.out.println(areas.get(0).viruses.size());
                    System.out.println(areas.get(1).viruses.size());
                    System.out.println(areas.get(2).viruses.size());
                }
                else{System.out.println("Win"); break;}
            }


            // loop check if virus dead in area1
            for(Virus vs : areas.get(0).getViruses()){
                if(!vs.isAlive()){
                    if(this.shop.getCurrentCredit() + vs.creditReward() <= shop.getMaxCredit()){
                        this.shop.setCurrentCredit(this.shop.getCurrentCredit() + vs.creditReward());
                    }else{
                        this.shop.setCurrentCredit(this.shop.getMaxCredit());
                    }
                }
            }
            // loop check if virus dead in area2
            for(Virus vs : areas.get(1).getViruses()){
                if(!vs.isAlive()){
                    if(this.shop.getCurrentCredit() + vs.creditReward() <= shop.getMaxCredit()){
                        this.shop.setCurrentCredit(this.shop.getCurrentCredit() + vs.creditReward());
                    }else{
                        this.shop.setCurrentCredit(this.shop.getMaxCredit());
                    }
                }
            }
            // loop check if virus dead in area3
            for(Virus vs : areas.get(2).getViruses()){
                if(!vs.isAlive()){
                    if(this.shop.getCurrentCredit() + vs.creditReward() <= shop.getMaxCredit()){
                        this.shop.setCurrentCredit(this.shop.getCurrentCredit() + vs.creditReward());
                    }else{
                        this.shop.setCurrentCredit(this.shop.getMaxCredit());
                    }
                }
            }

            // คำสั่งเดินของ Unit ในแต่ละ area
            areas.get(0).evaluate();
            areas.get(1).evaluate();
            areas.get(2).evaluate();

        }
        System.out.println("Game has Over");

    }
    private void toAddAntiboby(){
        System.out.println("area1 preAdd - " + areas.get(0).getAntibodies());
        areas.get(0).addAllAntibody(queueAntibobyArea1);
        System.out.println("area1 postAdd - " + areas.get(0).getAntibodies());
        queueAntibobyArea1.clear();
        System.out.println("area1 postClear - " + areas.get(0).getAntibodies());

        areas.get(1).addAllAntibody(queueAntibobyArea2);
        queueAntibobyArea2.clear();
        areas.get(2).addAllAntibody(queueAntibobyArea3);
        queueAntibobyArea3.clear();

    }
    private void toAddViruse(){

        areas.get(0).addAllVirus(queueVirusArea1);
        queueVirusArea1.clear();
        areas.get(1).addAllVirus(queueVirusArea2);
        queueVirusArea2.clear();
        areas.get(2).addAllVirus(queueVirusArea3);
        queueVirusArea3.clear();
    }

    public void putVirusToArea(int area){
        areas.get(area).addAllVirus(waveManager.allwave.get("Wave_"+waveManager.currentWaveCount.toString()+"Area_"+area));
    }

       @Override
       public void run(){
            startGameLoop();
        }


    private void waitState(int time){
        try{
            for(int i = 1 ; i <= time ; i++) {
                // ทำ if หรือ switch ทำการเลือกใช้ว่ามันทำอะไรอยู่
                if(timeManager.inputType.equals("slowdown")){
                    Thread.sleep((int)(1000*timeManager.slowDownMultiplier));
                    System.out.println("current time "+(i*(int)(1000*timeManager.slowDownMultiplier))/1000.0+ " second");
                }
                else if(timeManager.inputType.equals("fastforward")) {
                    Thread.sleep((int)(1000*timeManager.fastForwardMuliplier));
                    System.out.println("current time "+(i*(int)(1000*timeManager.fastForwardMuliplier))/1000.0+ " second");
                }
                else{
                    Thread.sleep((int)(1000));
                    System.out.println("current time "+i+ " second");
                }


            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public Integer getState(){
        return state;
    }

    public void setState(int state){
        this.state = state;
    }

    public GeneticCodeManager getGeneticCodeManager(){ return geneticCodeManager; }

    public Boolean getNotSpawnedYet() {
        return notSpawnedYet;
    }

    public TimeManager getTimeManager() {
        return timeManager;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public WaveManager getWaveManager() {
        return waveManager;
    }

    public Shop getShop() {
        return shop;
    }

    public List<Antibody> getQueueAntibobyArea1() {
        return queueAntibobyArea1;
    }

    public List<Antibody> getQueueAntibobyArea2() {
        return queueAntibobyArea2;
    }

    public List<Antibody> getQueueAntibobyArea3() {
        return queueAntibobyArea3;
    }

    public List<Virus> getQueueVirusArea1() {
        return queueVirusArea1;
    }

    public List<Virus> getQueueVirusArea2() {
        return queueVirusArea2;
    }

    public List<Virus> getQueueVirusArea3() {
        return queueVirusArea3;
    }

    public void setId(String id) {this.id = id;
        System.out.println("this.id = " + this.id + "  id = " + id);
    }
}
