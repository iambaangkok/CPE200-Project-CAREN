package com.maikw.CPE200ProjectCAREN;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("game")
public class Game {
    protected Integer state  = 1 ;
    protected Boolean spawn ;
    protected Integer screenWidth  = 1024 ;
    protected Integer screenHeight = 768 ;
    protected Double mousePositionX ;
    protected Double mousePositionY ;
    protected Integer activeAreaIndex;
    protected TimeManager timeManager ;
    protected Inventory inventory ;
    protected List<Area> areas;
    protected WaveManager waveManager ;
    protected GeneticCodeManager geneticCodeManager ;
    protected Shop shop ;



    public Game(){
        this.shop = new Shop();
        this.spawn = false ;
        this.areas = new ArrayList<Area>();
        areas.add(new Area("area1")); areas.add(new Area("area2")); areas.add(new Area("area3"));
        this.timeManager = new TimeManager();
        this.inventory = new Inventory();
        this.waveManager = new WaveManager();

    }

    public void move(){


    }



    public List<Integer> getScreen(){
        List<Integer> s = new ArrayList<Integer>();
        s.add(screenWidth);
        s.add(screenHeight);
        return  s;
    }


    public void startGameLoop(){




        while(true) {
            if (state == 1) {
                System.out.println("");
            }
            if (state == 2) {

                waveManager.getWaveInfo();

                if (waveManager.currentWaveCount == 1) {
                    waveManager.waveInfo.get(0);
                } else if (waveManager.currentWaveCount == 2) {
                    waveManager.waveInfo.get(1);
                } else if (waveManager.currentWaveCount == 3) {
                    waveManager.waveInfo.get(2);
                } else if (waveManager.currentWaveCount == 4) {
                    waveManager.waveInfo.get(3);
                } else {
                    waveManager.waveInfo.get(4);
                }

            }
        }
    }

    public static void main(String[] args) {
//        Game g = new Game();
////        g.startGameLoop();
//
//        while(true){
//            g.waitState();
//
//        }

        Shop shop = new Shop();
        Inventory inventory = new Inventory();
        shop.setInventory(inventory);

        shop.buyMelee();
        shop.buyMelee();
        shop.buyMelee();
        shop.buyMelee();

        System.out.println(shop.getMaxCredit());

    }


    private void waitState(){
        try{
            for(int i = 0 ; i <= 20 ; i++) {
//            System.out.println("Start of delay: "+ new Date());
                System.out.println("current time "+i+ " seccon");
                Thread.sleep(1000);
//            System.out.println("End of delay: "+ new Date());
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }




    /***
     * เซ็ตค่าเริ่มต้นของเกมส์ เช่น shop ประกาศแค่ครั้งเดียว
     * สร้าง wave ไว้รอแค่ครั้งเดียว
     *
     */
    private void setStart(){




    }


    private void upDate(){

        if(state == 1 ){
            if(spawn != false){

                spawn = false;
            }
        }


    }


    public Integer getState(){
        return state;
    }

    public void setState(int state){
        this.state = state;
    }
}
