package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.List;

public class TimeManager {
    protected Double fps ;
    protected Double deltaTime ;
    public Double slowDownMultiplier ;
    protected Double fastForwardMuliplier ;
//    protected String pause;
    protected String inputType;



    protected List<Integer> timeSate ;



// บางกอก ส่งค่า String มาว่าเป็น อะไร pause หรืออะไรต่างๆ
    public TimeManager(){
        this.fps = 60.0;
        this.deltaTime = 1.0 ;
        this.fastForwardMuliplier = 0.025 ;
        this.slowDownMultiplier = 2.5 ;
        this.timeSate = new ArrayList<>(); this.timeSate.add(1) ;this.timeSate.add(5);this.timeSate.add(10); this.timeSate.add(15); this.timeSate.add(30);
//        this.pause = "pause";
        this.inputType = "normal"; //fastforward
    }

    public Double getFps(){
        return fps;
    }

//    public String  getpush(){
//        return pause;
//    }
    public Double getDeltaTime() {
        return deltaTime;
    }


    public void setSlowDownMultiplier(Double slowDownMultiplier) {
        this.slowDownMultiplier = slowDownMultiplier*2;
    }

    public void setFastForwardMuliplier(Double fastForwardMuliplier) {
        this.fastForwardMuliplier = fastForwardMuliplier/2;
    }
//    public void setPush(String pause){
//        this.pause = pause;
//    }


    public String getInputType(){
        return inputType;
    }
    public void setInputType(String inputType){
        this.inputType = inputType;
    }

    public Double getSlowDownMultiplier() {
        return slowDownMultiplier;
    }

    public Double getFastForwardMuliplier() {
        return fastForwardMuliplier;
    }
}
