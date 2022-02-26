package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaveManager {
        protected Integer maxWaveCount  = 5 ;
        protected Integer currentWaveCount  = 0 ;
        protected Integer waveCount  = 1 ;
        protected  Integer timeBetweenWave  = 20 ;
        protected List<Virus> viruses ;
        protected Map<String,List<Virus>> allwave ;


    public WaveManager(){
        this.viruses = new ArrayList<>();
        this.allwave = new HashMap<>();

    }

    private void createUnitVirus(int area1melee, int area1ranged, int area1aoe) {

        for(int i = 0 ; i < area1melee;i++){
            viruses.add(UnitFactory.createVirus( "melee"));
        }
        for(int i = 0 ; i < area1ranged ;i++){
            viruses.add(UnitFactory.createVirus( "ranged"));
        }
        for (int i = 0 ; i < area1aoe;i++){
            viruses.add(UnitFactory.createVirus( "aoe"));
        }

        allwave.put("Wave_"+ waveCount.toString() ,viruses);
        waveCount+=1;
        this.viruses = new ArrayList<>();
    }

    public void genVirus() {

        createUnitVirus(3,1,0);
        createUnitVirus(5,1,0);
        createUnitVirus(10,3,1);
        createUnitVirus(10,5,3);
        createUnitVirus(50,50,50);

    }



    public Integer getMaxWaveCount() {
        return maxWaveCount;
    }

    public Integer getCurrentWaveCount() {
        return waveCount;
    }

    public Integer getTimeBetweenWave() {
        return timeBetweenWave;
    }
}
