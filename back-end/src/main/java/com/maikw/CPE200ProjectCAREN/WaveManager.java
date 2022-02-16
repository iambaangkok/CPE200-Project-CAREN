package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.List;

public class WaveManager {
        protected Integer maxWaveCont  = 20 ;
        protected Integer currentWaveCount  = 0 ;
        protected  Integer timeBetweenWave  = 0 ;
        protected List<Wave> waveInfo ;




    private WaveManager(){
        this.waveInfo =  new ArrayList<Wave>();
    }

    private Wave createWave(int wavenumber,int area1melee, int area1ranged, int area1aoe){
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

        return  wave;
    }





}
