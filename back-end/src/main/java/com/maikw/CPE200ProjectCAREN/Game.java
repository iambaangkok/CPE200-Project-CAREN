package com.maikw.CPE200ProjectCAREN;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Component("game")
public class Game {
    protected Integer state  = 1 ;
    protected Boolean spawn ;   // เป็นตัวกำหนดว่ายังไม่ได้เริ่มวางตัว
    protected Integer screenWidth  = 1024 ;
    protected Integer screenHeight = 768 ;
    protected TimeManager timeManager ;
    protected Inventory inventory ;
    protected List<Area> areas;
    protected WaveManager waveManager ;
    protected Shop shop ;
    protected Unit unit;
    protected List<Antibody> queueAntibobyArea1 ;
    protected List<Antibody> queueAntibobyArea2 ;
    protected List<Antibody> queueAntibobyArea3 ;
    protected List<Virus> queueVirusArea1 ;
    protected List<Virus> queueVirusArea2 ;
    protected List<Virus> queueVirusArea3 ;


    public Game(){
        this.shop = new Shop();
        this.spawn = true ;
        this.areas = new ArrayList<Area>();

        this.timeManager = new TimeManager();
        this.inventory = new Inventory();
        this.waveManager = new WaveManager();
        this.queueAntibobyArea1 = new ArrayList<Antibody>();
        this.queueAntibobyArea2 = new ArrayList<Antibody>();
        this.queueAntibobyArea3 = new ArrayList<Antibody>();

        this.queueVirusArea1 = new ArrayList<Virus>();
        this.queueVirusArea2 = new ArrayList<Virus>();
        this.queueVirusArea3 = new ArrayList<Virus>();

        areas.add(new Area("area1", queueVirusArea1));
        areas.add(new Area("area2", queueVirusArea2));
        areas.add(new Area("area3", queueVirusArea3));



    }


    public List<Integer> getScreen(){
        List<Integer> s = new ArrayList<Integer>();
        s.add(screenWidth);
        s.add(screenHeight);
        return  s;
    }

    public void startGameLoop(){
//        System.out.println("Yaeggggg");
//        Antibody a = UnitFactory.createAntibody("melee");
//        Antibody b = UnitFactory.createAntibody("melee");
//        Antibody c = UnitFactory.createAntibody("melee");
//        a.positionX= 10.0;
//        a.positionY = 0.0;
//        queueAntibobyArea1.add(a);
//        b.positionX= 10.0;
//        b.positionY = 0.0;
//        queueAntibobyArea2.add(b);
//        c.positionX= 10.0;
//        c.positionY = 0.0;
//        queueAntibobyArea3.add(c);



        waveManager.genVirus();

        while (areas.get(0).antibodies.size() != 0 || areas.get(1).antibodies.size() != 0
                || areas.get(2).antibodies.size() != 0 || spawn){

            System.out.println(areas.get(0).antibodies.size() + " " + areas.get(1).antibodies.size() + " " +
            areas.get(2).antibodies.size());

            while(timeManager.inputType.equals("pause")) {
                waitState(1);
                System.out.println("pause state");
            }

            toAddAntiboby();
            toAddViruse();

//            System.out.println("ลงยูนิด");

            waitState(timeManager.timeSate.get(0)); // สปีดของ loop

        // test genAnti 1 ตัว
//            System.out.println(inventory.meleeCount);
//            InventoryController ic = new InventoryController(this);
//            System.out.println(ic.pickupUnit("melee",areas.get(0),0.0,0.0));


            if(spawn == true){waitState(timeManager.timeSate.get(1)); this.spawn = false;} //timeManager.timeSate.get(1) //คือเวลาที่กำลังจะปล่อยไวรัส
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
            areas.get(0).snapViruses();
            areas.get(1).snapViruses();
            areas.get(2).snapViruses();

            // คำสั่งเดินของ Unit ในแต่ละ area
            areas.get(0).evaluate();
            areas.get(1).evaluate();
            areas.get(2).evaluate();

//            areas.get(0).snapViruses();
//            areas.get(1).snapViruses();
//            areas.get(2).snapViruses();



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

    public static void main(String[] args) {
        Game game = new Game();
        game.startGameLoop();
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
}
