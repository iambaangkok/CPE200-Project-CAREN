package com.maikw.CPE200ProjectCAREN;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        this.spawn = true ;
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
                || areas.get(2).antibodies.size() != 0 || spawn){

            waitState(timeManager.timeSate.get(0));

//            if(timeManager.pause == true){
//                continue;
//            }

            {
                // เป็นช่วงที่รอให้ คนเล่นวาง anti เข้ามาทำรอบเดียว
                Antibody A = UnitFactory.createAntibody("melee");
                A.setArea(areas.get(0));
                areas.get(0).addAntibody(A);
            }
            if(spawn == true){waitState(2); this.spawn = false;} //timeManager.timeSate.get(1)
            if(areas.get(0).viruses.size() == 0 && areas.get(1).viruses.size() == 0
                    && areas.get(2).viruses.size() == 0 ) {
                waveManager.currentWaveCount += 1;
                if (waveManager.currentWaveCount <= waveManager.maxWaveCount) {

                    waitState(1);    //timeManager.timeSate.get(4)

                    putVirusToArea(0);
                    putVirusToArea(1);
                    putVirusToArea(2);

                    System.out.println(areas.get(0).viruses.size());
                    System.out.println(areas.get(1).viruses.size());
                    System.out.println(areas.get(2).viruses.size());

                    System.out.println("Snapppp!");
                    areas.get(0).snapViruse();
                    areas.get(1).snapViruse();
                    areas.get(2).snapViruse();
                }
                else{System.out.println("Win");}
            }
            areas.get(0).snapViruse();
            areas.get(1).snapViruse();
            areas.get(2).snapViruse();
            // คำสั่งเดินของ Unit ในแต่ละ area
            areas.get(0).evaluate();
            areas.get(1).evaluate();
            areas.get(2).evaluate();
            // ตี
//            areas.get(0).evaluate();
//            areas.get(1).evaluate();
//            areas.get(2).evaluate();


        }
        System.out.println("you อ่อนหัด");

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

//        Antibody A = UnitFactory.createAntibody("melee");
//        A.setArea(game.areas.get(0));
//        game.areas.get(0).addAntibody(A);
//
//        Antibody B = UnitFactory.createAntibody("melee");
//        B.setArea(game.areas.get(1));
//        game.areas.get(1).addAntibody(B);


        game.startGameLoop();
    }

    private void waitState(int time){
        try{
            for(int i = 1 ; i <= time ; i++) {

                System.out.println("current time "+i+ " second");
                Thread.sleep(1000);

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
