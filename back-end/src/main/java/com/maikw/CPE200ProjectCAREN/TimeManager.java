package com.maikw.CPE200ProjectCAREN;

import java.util.List;

public class TimeManager {
    protected Double fps ;
    protected Double deltaTime ;
    protected Double slowDownMultiplier ;
    protected Double fastForwardMuliplier ;
    protected List<String> timeSate ;


    public TimeManager(){

    }

    public Double getFps(){
        return fps;
    }

    public Double getDeltaTime() {
        return deltaTime;
    }

    public void setTimeSate(List<String> timeSate) {
        this.timeSate = timeSate;
    }

    public void setSlowDownMultiplier(Double slowDownMultiplier) {
        this.slowDownMultiplier = slowDownMultiplier;
    }

    public void setFastForwardMuliplier(Double fastForwardMuliplier) {
        this.fastForwardMuliplier = fastForwardMuliplier;
    }

}
