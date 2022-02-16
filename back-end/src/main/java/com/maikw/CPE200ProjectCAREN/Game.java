package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.List;

public class Game {
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


}
