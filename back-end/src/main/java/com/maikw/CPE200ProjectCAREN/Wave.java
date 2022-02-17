package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.List;

public class Wave {
    protected List<Virus> wave1;
    protected List<Virus> wave2;
    protected List<Virus> wave3;
    protected List<Virus> wave4;
    protected List<Virus> wave5;

    protected int waveNumber;

    public Wave(int waveNumber) {
        this.wave1 = new ArrayList<Virus>();
        this.wave2 = new ArrayList<Virus>();
        this.wave3 = new ArrayList<Virus>();
        this.wave4 = new ArrayList<Virus>();
        this.wave5 = new ArrayList<Virus>();
        this.waveNumber = waveNumber;
    }

    public void addWave(Virus virus){
        if(waveNumber == 1 ){
            wave1.add(virus);
        }else if(waveNumber == 2 ){
            wave2.add(virus);
        }else if(waveNumber == 3 ){
            wave3.add(virus);
        }else if(waveNumber == 4) {
            wave4.add(virus);
        }else {
            wave5.add(virus);}

    }







    public List<Virus> getWave1() {
        return wave1;
    }

    public List<Virus> getWave2() {
        return wave2;
    }

    public List<Virus> getWave3() {
        return wave3;
    }

    public List<Virus> getWave4() {
        return wave4;
    }

    public List<Virus> getWave5() {
        return wave5;
    }

    //
//    public void setArea1Virus(List<Virus> area1Virus) {
//        this.area1Virus = area1Virus;
//    }
//
//    public List<Virus> getAreaVirus(Integer number) {
//
//        if (number == 1) {
//            return area1Virus;
//        } else if (number == 2) {
//            return area2Virus;
//        } else {
//            return area3Virus;
//        }
//    }


}