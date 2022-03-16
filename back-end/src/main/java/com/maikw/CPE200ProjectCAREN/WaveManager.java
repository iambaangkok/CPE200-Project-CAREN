package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaveManager {
    protected Integer maxWaveCount = 5;
    protected Integer currentWaveCount = 0;
    protected Integer waveCount = 1;
    protected Integer timeBetweenWave  = 20;
    protected List<Virus> viruses1;
    protected List<Virus> viruses2;
    protected List<Virus> viruses3;
    protected Map<String,List<Virus>> allwave ;
    private final boolean DEBUG = true;



    public WaveManager(){
        this.maxWaveCount = Config.maxWave;
        this.viruses1 = new ArrayList<>();
        this.viruses2 = new ArrayList<>();
        this.viruses3 = new ArrayList<>();
        this.allwave = new HashMap<>();

    }

    private void createUnitVirus(int area1melee, int area1ranged, int area1aoe) {

        for(int i = 0 ; i < area1melee;i++){
            viruses1.add(UnitFactory.createVirus( "melee"));
            viruses2.add(UnitFactory.createVirus( "melee"));
            viruses3.add(UnitFactory.createVirus( "melee"));
        }
        for(int i = 0 ; i < area1ranged ;i++){
            viruses1.add(UnitFactory.createVirus( "ranged"));
            viruses2.add(UnitFactory.createVirus( "ranged"));
            viruses3.add(UnitFactory.createVirus( "ranged"));
        }
        for (int i = 0 ; i < area1aoe;i++){
            viruses1.add(UnitFactory.createVirus( "aoe"));
            viruses2.add(UnitFactory.createVirus( "aoe"));
            viruses3.add(UnitFactory.createVirus( "aoe"));
        }

        allwave.put("Wave_"+ waveCount.toString() +"Area_"+0, viruses1);
        allwave.put("Wave_"+ waveCount.toString() +"Area_"+1, viruses2);
        allwave.put("Wave_"+ waveCount.toString() +"Area_"+2, viruses3);
        waveCount+=1;
        this.viruses1 = new ArrayList<>();
        this.viruses2 = new ArrayList<>();
        this.viruses3 = new ArrayList<>();
    }

    public void addVirus() {
            for (int i = 0 ; i < maxWaveCount ; ++i) {
                createUnitVirus(Config.meleeCountPerWave[i], Config.rangedCountPerWave[i], Config.aoeCountPerWave[i]);
                if(DEBUG) System.out.println(Config.meleeCountPerWave[i]+" , " + Config.rangedCountPerWave[i] + " , "+ Config.aoeCountPerWave[i]);
            }

//        createUnitVirus(2,3 ,3 );
//        createUnitVirus(2,3 ,3 );
//        createUnitVirus(2,3 ,3 );
//        createUnitVirus(2,3 ,3 );
//        createUnitVirus(2,3 ,3 );

    }



    public Integer getMaxWaveCount() {
        return maxWaveCount;
    }

    public Integer getCurrentWaveCount() {
        return currentWaveCount;
    }

    public Integer getTimeBetweenWave() {
        return timeBetweenWave;
    }

    public void setCurrentWaveCount(int currentWaveCount){
        this.currentWaveCount = currentWaveCount;
    }

    public void setMaxWaveCount(Integer maxWaveCount) {
        this.maxWaveCount = maxWaveCount;
    }

}
