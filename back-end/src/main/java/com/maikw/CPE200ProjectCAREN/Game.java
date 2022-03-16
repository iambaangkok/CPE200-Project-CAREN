package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.Iterator;
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

    private final boolean DEBUG = true;


    public Game(){
        Config.readFile("config/config_0.txt");
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
        waitState(5);
        waveManager.addVirus();

        while (areas.get(0).antibodies.size() != 0 || areas.get(1).antibodies.size() != 0
                || areas.get(2).antibodies.size() != 0 || notSpawnedYet){
            if(DEBUG) {
                System.out.println("Game ID = " + id);
                System.out.println(areas.get(0).antibodies.size() + " " + areas.get(1).antibodies.size() + " " +
                        areas.get(2).antibodies.size());
            }

            while(timeManager.inputType.equals("pause")) {
                waitState(1);
                if(DEBUG) System.out.println("pause state");
                toAddAntiboby();
                pickUpAntiUnit();


            }

            waitState(timeManager.timeSate.get(0)); // สปีดของ loop




            while (notSpawnedYet && ( areas.get(0).antibodies.size() == 0 || areas.get(1).antibodies.size() == 0 || areas.get(2).antibodies.size() == 0 )){
                if(DEBUG) System.out.println("You must place at least 1 unit in each area.");
                waitState(1);
                pickUpAntiUnit();
                toAddAntiboby();
                toAddViruse();
            }
            notSpawnedYet = false;
            toAddAntiboby();
            toAddViruse();

            if(!notSpawnedYet && areas.get(0).viruses.size() == 0 && areas.get(1).viruses.size() == 0
                    && areas.get(2).viruses.size() == 0 ) {
                if (waveManager.currentWaveCount < waveManager.maxWaveCount) {
                    waveManager.currentWaveCount += 1;

                    for (int i = 0 ; i < timeManager.timeSate.get(4);i++) {
                        waitState(1);
                        toAddAntiboby();
                        pickUpAntiUnit();
                    }   //timeManager.timeSate.get(4) // 30 วิ

                    putVirusToArea(0);
                    putVirusToArea(1);
                    putVirusToArea(2);
                    if(DEBUG) {
                        System.out.println(areas.get(0).viruses.size());
                        System.out.println(areas.get(1).viruses.size());
                        System.out.println(areas.get(2).viruses.size());
                    }
                }
                else{ if(DEBUG) System.out.println("Win"); break;}
            }


            // loop check if virus dead in area
            for(int i = 0 ; i < 3; ++i){
                Iterator<Virus> vsIterator = areas.get(i).getViruses().iterator();
                while(vsIterator.hasNext()){
                    Virus vs = vsIterator.next();
                    if(!vs.isAlive()){
                        if(DEBUG){
                            System.out.println("Name : " + vs.getName() + " is dead");
                        }
                        if(this.shop.getCurrentCredit() + vs.creditReward() <= shop.getMaxCredit()){
                            this.shop.setCurrentCredit(this.shop.getCurrentCredit() + vs.creditReward());
                        }else{
                            this.shop.setCurrentCredit(this.shop.getMaxCredit());
                        }
                        if(DEBUG){
                            System.out.println("Current Credit : " + this.shop.getCurrentCredit());
                        }
                        vsIterator.remove();
                        areas.get(i).removeVirus(vs);
                    }
                }
            }



            // คำสั่งเดินของ Unit ในแต่ละ area
            areas.get(0).evaluate();
            areas.get(1).evaluate();
            areas.get(2).evaluate();

        }
        if(DEBUG) System.out.println("Game has Over");

    }
    private void toAddAntiboby(){
        if(DEBUG) System.out.println("area1 preAdd - " + areas.get(0).getAntibodies());
        areas.get(0).addAllAntibody(queueAntibobyArea1);
        if(DEBUG) System.out.println("area1 postAdd - " + areas.get(0).getAntibodies());
        queueAntibobyArea1.clear();
        if(DEBUG) System.out.println("area1 postClear - " + areas.get(0).getAntibodies());

        areas.get(1).addAllAntibody(queueAntibobyArea2);
        queueAntibobyArea2.clear();
        areas.get(2).addAllAntibody(queueAntibobyArea3);
        queueAntibobyArea3.clear();

    }

    private void pickUpAntiUnit(){
        for(int i = 0 ; i < 3; ++i){
            Iterator<Antibody> abIterator = areas.get(i).getAntibodies().iterator();
            while(abIterator.hasNext()){
                Antibody ab = abIterator.next();
                if(!ab.isAlive() && !ab.toSpawn){
                    if(DEBUG) System.out.println("Name : " + ab.getName() + " was picked up");
                    abIterator.remove();
                    areas.get(i).removeAntibody(ab);
                }
            }
        }
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
                    if(DEBUG) System.out.println("current time "+(i*(int)(1000*timeManager.slowDownMultiplier))/1000.0+ " second");
                }
                else if(timeManager.inputType.equals("fastforward")) {
                    Thread.sleep((int)(1000*timeManager.fastForwardMuliplier));
                    if(DEBUG) System.out.println("current time "+(i*(int)(1000*timeManager.fastForwardMuliplier))/1000.0+ " second");
                }
                else{
                    Thread.sleep((int)(1000*0.125));
                    if(DEBUG) System.out.println("current time "+i+ " second");
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

    public void setId(String id) {
        this.id = id;
        if(DEBUG) System.out.println("this.id = " + this.id + "  id = " + id);
    }
}
