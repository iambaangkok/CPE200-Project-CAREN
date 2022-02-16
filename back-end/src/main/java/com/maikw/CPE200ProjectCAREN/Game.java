package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.List;

public class Game {
    protected Integer state  = 1 ;
    protected Boolean spawn ;
    protected Integer screenWidth  = 1024 ;
    protected Integer screenHeight = 768 ;
    protected Double mousePositionX ;
    protected Double mousePositionY ;
    protected Integer activeAreaIndex;
    protected ZoomManager zoomManager;
    protected TimeManager timeManager ;
    protected Inventory inventory ;
    protected List<Area> areas;
    protected WaveManager waveManager ;
    protected GeneticCodeManager geneticCodeManager ;

    public Game(){

    this.spawn = false ;
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
//        while(state == 1){
//            waveManager.waveInfo.get()
//            spawn = true ;
//            upDate();
//
//        }
        while(true) {
            if (state == 1) {
                System.out.println("");
            }
            if (state == 2) {
                if (waveManager.currentWaveCount == 1) {
                    waveManager.waveInfo.get(0);
                } else if (waveManager.currentWaveCount == 2) {
                    waveManager.waveInfo.get(1);
                } else if (waveManager.currentWaveCount == 3) {
                    waveManager.waveInfo.get(2);
                }
            } else if (waveManager.currentWaveCount == 4) {
                waveManager.waveInfo.get(3);
            } else {
                waveManager.waveInfo.get(4);
            }
        }
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.startGameLoop();


    }




    private void upDate(){

        Inventory inventory = new Inventory(0,0,0);


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
