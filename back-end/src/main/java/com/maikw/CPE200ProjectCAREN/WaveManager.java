package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.List;

public class WaveManager {
        protected Integer maxWaveCont ;
        protected Integer currentWaveCount  = 0 ;
        protected  Integer timeBetweenWave  = 0 ;
        protected List<Wave> waveInfo = new ArrayList<Wave>();




    private WaveManager(){

    }

    private Wave createWave(int area1melee, int area1ranged, int area1aoe){
        Wave wave = new Wave(1);
        for(int i = 0 ; i < area1melee;i++){
            wave.addArea(UnitFactory.createVirus("viruemelee"+i, "melee"));
        }

        return  wave;
    }





}
