package com.maikw.CPE200ProjectCAREN;

import java.util.LinkedList;
import java.util.List;

public class Area {

    protected List<Unit> units;
    protected List<Virus> viruses;
    protected List<Antibody> antibodies;

    public Area(){
        this.units = new LinkedList<Unit>(); 
        this.viruses = new LinkedList<Virus>(); 
        this.antibodies = new LinkedList<Antibody>();
    }

    private void addUnit(Unit dummy){
        this.units.add(dummy);
    }

    private void addVirus(Virus dummy){
        this.viruses.add(dummy);
    }

    private void addAntibody(Antibody dummy){
        this.antibodies.add(dummy);
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
}
