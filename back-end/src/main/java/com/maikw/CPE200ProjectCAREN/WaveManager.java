package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.List;

public class WaveManager {
        protected Integer maxWaveCount  = 5 ;
        protected Integer currentWaveCount  = 1 ;
        protected  Integer timeBetweenWave  = 20 ;
        protected List<Wave> waveInfo ;




    public WaveManager(){
        this.waveInfo =  new ArrayList<Wave>();
    }

    public Wave createWave(int wavenumber,int area1melee, int area1ranged, int area1aoe){
        Wave wave = new Wave(wavenumber);

        for(int i = 0 ; i < area1melee;i++){
            wave.addArea(UnitFactory.createVirus("viruemelee"+i, "melee"));
        }

        for(int i = 0 ; i < area1ranged ; i++){
            wave.addArea(UnitFactory.createVirus("viruerange"+i, "range"));
        }

        for (int i = 0 ; i < area1aoe; i++){
            wave.addArea(UnitFactory.createVirus("virueaoe"+i, "aoe"));
        }
        currentWaveCount += 1 ;
        return  wave;
    }


    public void setWaveInfo(){
        waveInfo.add(createWave(1,5,2,0));
        waveInfo.add(createWave(2,7,3,1));
        waveInfo.add(createWave(3,15,5,3));
        waveInfo.add(createWave(4,15,7,4));
        waveInfo.add(createWave(5,25,7,2));
    }




}
