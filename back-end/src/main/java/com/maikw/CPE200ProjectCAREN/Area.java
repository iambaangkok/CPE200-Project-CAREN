package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.List;

public class Area {

    protected List<Unit> units;
    protected List<Virus> viruses;
    protected List<Antibody> antibodies;
    protected String name;

    public Area(String name){
        this.units = new ArrayList<Unit>();
        this.viruses = new ArrayList<Virus>();
        this.antibodies = new ArrayList<Antibody>();
        this.name = name;
    }

    private void addUnit(Unit dummy){
        this.units.add(dummy);
    }

    private void addVirus(Virus dummy){
        this.viruses.add(dummy);
        this.addUnit(dummy);
    }

    private void addAntibody(Antibody dummy){
        this.antibodies.add(dummy);
        this.addUnit(dummy);
    }

    // 3 level 0 = green light -> all good , 1 = yellow light -> antibodies:viruses = 1:3 , 2 = red light -> area taken
    public int alertLevel(){ 
        if(this.antibodies.size() == 0){
            return 2;
        }else if(3*this.antibodies.size() <= this.viruses.size()){
            return 1;
        }else{
            return 0;
        }
    }

    public boolean isTaken(){
        return this.alertLevel() == 2;
    }
    
    public List<Unit> getUnits() {
        return units;
    }

    public List<Virus> getViruses() {
        return viruses;
    }

    public List<Antibody> getAntibodies() {
        return antibodies;
    }

    public String getName() {
        return name;
    }
}
