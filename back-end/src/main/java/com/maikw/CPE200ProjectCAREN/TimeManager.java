package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.List;

public class TimeManager {
    protected Double fps ;
    protected Double deltaTime ;
    protected Double slowDownMultiplier ;
    protected Double fastForwardMuliplier ;
    protected boolean pause;
    protected List<Integer> timeSate ;


    public TimeManager(){
        this.fps = 60.0;
        this.deltaTime = 1.0 ;
        this.fastForwardMuliplier = 0.5;
        this.slowDownMultiplier = 1.5;
        this.pause = true;
        this.timeSate = new ArrayList<>(); this.timeSate.add(1) ;this.timeSate.add(5);this.timeSate.add(10); this.timeSate.add(15); this.timeSate.add(30);
    }

    public Double getFps(){
        return fps;
    }

    public Boolean getpush(){
        return pause;
    }
    public Double getDeltaTime() {
        return deltaTime;
    }


    public void setSlowDownMultiplier(Double slowDownMultiplier) {
        this.slowDownMultiplier = slowDownMultiplier;
    }

    public void setFastForwardMuliplier(Double fastForwardMuliplier) {
        this.fastForwardMuliplier = fastForwardMuliplier;
    }
    public void setPush(Boolean pause){
        this.pause = pause;
    }
}
