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
    protected Double mousePositionX ;
    protected Double mousePositionY ;
    protected Integer activeAreaIndex ;
    protected TimeManager timeManager ;
    protected Inventory inventory ;
    protected List<Area> areas;
    protected WaveManager waveManager ;
    protected GeneticCodeManager geneticCodeManager ;
    protected Shop shop ;
    protected Unit unit;
    protected List<Antibody> queueAntibobyArea1 ;
    protected List<Antibody> queueAntibobyArea2 ;
    protected List<Antibody> queueAntibobyArea3 ;

    public Game(){
        this.shop = new Shop();
        this.spawn = true ;
        this.areas = new ArrayList<Area>();
        areas.add(new Area("area1")); areas.add(new Area("area2")); areas.add(new Area("area3"));
        this.timeManager = new TimeManager();
        this.inventory = new Inventory();
        this.waveManager = new WaveManager();
        this.queueAntibobyArea1 = new ArrayList<Antibody>();
        this.queueAntibobyArea2 = new ArrayList<Antibody>();
        this.queueAntibobyArea3 = new ArrayList<Antibody>();



    }


    public List<Integer> getScreen(){
        List<Integer> s = new ArrayList<Integer>();
        s.add(screenWidth);
        s.add(screenHeight);
        return  s;
    }

    public void startGameLoop(){
        System.out.println("Yaeggggg");

        waveManager.genVirus();

        while (areas.get(0).antibodies.size() != 0 || areas.get(1).antibodies.size() != 0
                || areas.get(2).antibodies.size() != 0 || spawn){


            while(timeManager.inputType.equals("pause")) {
                System.out.println("pause state");
            }

            toAddAntiboby();

            waitState(timeManager.timeSate.get(0));

//            {
//                // เป็นช่วงที่รอให้ คนเล่นวาง anti เข้ามาทำรอบเดียว
//                Antibody A = UnitFactory.createAntibody("melee");
//                A.setArea(areas.get(0));
//                areas.get(0).addAntibody(A);
//            }

            if(spawn == true){waitState(2); this.spawn = false;} //timeManager.timeSate.get(1)
            if(areas.get(0).viruses.size() == 0 && areas.get(1).viruses.size() == 0
                    && areas.get(2).viruses.size() == 0 ) {

                waveManager.currentWaveCount += 1;

                if (waveManager.currentWaveCount <= waveManager.maxWaveCount) {

                    waitState(1);    //timeManager.timeSate.get(4)

                    putVirusToArea(0);
                    putVirusToArea(1);
                    putVirusToArea(2);
                    System.out.println(waveManager.currentWaveCount);
//                    System.out.println(waveManager.currentWaveCount);
                    System.out.println(areas.get(0).viruses.size());
                    System.out.println(areas.get(1).viruses.size());
                    System.out.println(areas.get(2).viruses.size());

//                    System.out.println("Snapppp!");
//                    areas.get(0).snapViruses();
//                    areas.get(1).snapViruses();
//                    areas.get(2).snapViruses();
                }
                else{System.out.println("Win"); break;}
            }
//            areas.get(0).snapViruses();
//            areas.get(1).snapViruses();
//            areas.get(2).snapViruses();
            // คำสั่งเดินของ Unit ในแต่ละ area
            areas.get(0).evaluate();
            areas.get(1).evaluate();
            areas.get(2).evaluate();
            // ตี
//            areas.get(0).evaluate();
//            areas.get(1).evaluate();
//            areas.get(2).evaluate();


        }
        System.out.println("Game has Over");

    }

    private void toAddAntiboby(){
        while (queueAntibobyArea1.isEmpty() == false){
            for(Antibody antibody:queueAntibobyArea1){
                areas.get(0).addAntibody(antibody);
            }
            break;
        }
        while(queueAntibobyArea2.isEmpty() == false){
            for(Antibody antibody:queueAntibobyArea2){
                areas.get(1).addAntibody(antibody);
            }
            break;
        }
        while(queueAntibobyArea3.isEmpty() == false){
            for(Antibody antibody:queueAntibobyArea3){
                areas.get(2).addAntibody(antibody);
            }
            break;
        }
    }

    public void putVirusToArea(int area){
        areas.get(area).addAllVirus(waveManager.allwave.get("Wave_"+waveManager.currentWaveCount.toString()));
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
                    System.out.println("current time "+i*(int)(1000*timeManager.slowDownMultiplier)+ " second");
                }
                else if(timeManager.inputType.equals("fastforward")) {
                    Thread.sleep((int)(1000*timeManager.fastForwardMuliplier));
                    System.out.println("current time "+i*(int)(1000*timeManager.fastForwardMuliplier)+ " second");
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



    private void upDate(){


    }


    public Integer getState(){
        return state;
    }

    public void setState(int state){
        this.state = state;
    }
}
