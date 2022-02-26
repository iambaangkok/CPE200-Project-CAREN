package com.maikw.CPE200ProjectCAREN;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    public Game(){
        this.shop = new Shop();
        this.spawn = false ;
        this.areas = new ArrayList<Area>();
        areas.add(new Area("area1")); areas.add(new Area("area2")); areas.add(new Area("area3"));
        this.timeManager = new TimeManager();
        this.inventory = new Inventory();
        this.waveManager = new WaveManager();


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
                || areas.get(2).antibodies.size() != 0){

            waitState(timeManager.timeSate.get(0));

//            if(timeManager.pause == true){
//                continue;
//            }

            if(spawn == false){waitState(timeManager.timeSate.get(1)); this.spawn = true;}
            if(areas.get(0).viruses.size() == 0 && areas.get(1).viruses.size() == 0
                    && areas.get(2).viruses.size() == 0 ) {
                waveManager.currentWaveCount += 1;
                if (waveManager.currentWaveCount <= waveManager.maxWaveCount) {
                    waitState(timeManager.timeSate.get(4));
                    putVirusToArea(0);
                    putVirusToArea(1);
                    putVirusToArea(2);

                    System.out.println(areas.get(0).viruses.size());
                    System.out.println(areas.get(1).viruses.size());
                    System.out.println(areas.get(2).viruses.size());

                    System.out.println("Snapppp!");
//                    areas.get(0).snap();
//                    areas.get(1).snap();
//                    areas.get(2).snap();
                }
                else{System.out.println("Win");}
            }
            // คำสั่งเดินของ Unit ในแต่ละ area
            areas.get(0).evaluate();
            areas.get(1).evaluate();
            areas.get(2).evaluate();


        }

    }


    /***
     * เซ็ตค่าเริ่มต้นของเกมส์ เช่น shop ประกาศแค่ครั้งเดียว
     * สร้าง wave ไว้รอแค่ครั้งเดียว
     */
    private void setStart(){


    }


    public void putVirusToArea(int area){
        areas.get(area).addAllVirus(waveManager.allwave.get("Wave_"+waveManager.currentWaveCount.toString()));
    }

    public static void main(String[] args) {

        Game game = new Game();

        Antibody A = UnitFactory.createAntibody("melee");
        A.setArea(game.areas.get(0));
        game.areas.get(0).addAntibody(A);
        game.startGameLoop();
    }

    private void waitState(int time){
        try{
            for(int i = 1 ; i <= time ; i++) {
//            System.out.println("Start of delay: "+ new Date());
                System.out.println("current time "+i+ " seccon");
                Thread.sleep(1000);
//            System.out.println("End of delay: "+ new Date());
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
