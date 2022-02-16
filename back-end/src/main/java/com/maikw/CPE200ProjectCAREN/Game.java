package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.List;

public class Game {
    protected Integer state  =1 ;
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
        while(state == 1){
            upDate();




        }
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.startGameLoop();

    }




    private void upDate(){

        Inventory inventory = new Inventory(0,0,0);


        if(state == 1 ){

        }


    }


    public Integer getState(){
        return state;
    }

    public void setState(int state){
        this.state = state;
    }
}
