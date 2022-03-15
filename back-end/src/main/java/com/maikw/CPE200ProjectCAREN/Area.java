package com.maikw.CPE200ProjectCAREN;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Area {

    protected List<Unit> units;
    protected List<Virus> viruses;
    protected List<Antibody> antibodies;
    protected double radius = 100;
    protected String name;
    protected List<Virus> rebornQueue;

    public Area(String name){
        this.units = new ArrayList<Unit>();
        this.viruses = new ArrayList<Virus>();
        this.antibodies = new ArrayList<Antibody>();
        this.name = name;
    }

    public Area(String name, List<Virus> rebornQueue){
        this.units = new ArrayList<Unit>();
        this.viruses = new ArrayList<Virus>();
        this.antibodies = new ArrayList<Antibody>();
        this.name = name;
        this.rebornQueue = rebornQueue;
    }

    public void addUnit(Unit dummy){
        this.units.add(dummy);
    }

    public void addVirus(Virus dummy){
        dummy.setArea(this);
        this.viruses.add(dummy);
        this.addUnit(dummy);
    }

    /**
     *
     * @param dummy รับเป็น list ของ Virus เพื่อที่ง่ายต่อการใช้งานที่เก็บมา
     */
    public void addAllVirus(List<Virus> dummy){
        for(Virus virus : dummy){
            this.addVirus(virus);
            System.out.println("Set to area = " + virus.area.getName());
        }
    }

    public void addAntibody(Antibody dummy){
        dummy.setArea(this);
        this.antibodies.add(dummy);
        this.addUnit(dummy);
    }

    /**
     *
     * @param dummy รับเป็น list ของ Antibody เพื่อที่ง่ายต่อการใช้งานที่เก็บมา
     */
    public void addAllAntibody(List<Antibody> dummy){
        for(Antibody antibody : dummy){
            this.addAntibody(antibody);
        }
    }

    public void removeUnit(Unit dummy){
        this.units.remove(dummy);
    }

    public void removeVirus(Virus dummy){
        this.viruses.remove(dummy);
        dummy.setArea(null);
    }

    public void removeAntibody(Antibody dummy){
        this.antibodies.remove(dummy);
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

    public void evaluate(){
        Iterator<Unit> unitIterator = units.iterator();
        while(unitIterator.hasNext()){
            Unit unit = unitIterator.next();
            if(unit.isAlive()){
                unit.setDidActionCommand(false);
                unit.evaluate();
                System.out.println(name);
                System.out.println(unit.getCurrentHealth());
            }else{ // if Unit is DEAD
                if (unit.unitClass.equals("virus")){
                    unitIterator.remove();
                    removeVirus((Virus) unit);
                }
                if (unit.unitClass.equals("antibody")){
                    unitIterator.remove();
                    if(unit.toSpawn){
                        ((Antibody)unit).virusToSpawn(rebornQueue);
                    }else{
                        unit.setArea(null);
                    }
                    removeAntibody((Antibody) unit);
                }
            }
        }
    }

    public boolean canPlace(double positionX, double positionY){
        for(Unit u : units){
            if(u.getPositionX() == positionX && u.getPositionY() == positionY) return false;
        }
        return true;
    }

    public boolean isTaken(){
        return this.alertLevel() == 2;
    }


    public void snapViruses() {
        units.removeAll(viruses);
        viruses.clear();
        System.out.println("Has gone");
    }

    public int getAlertLevel(){
        return this.getAlertLevel();
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

    public double getRadius(){
        return radius;
    }

//    public static void main(String[] args) {
//        Area area = new Area("Area1);
//        Antibody ab = UnitFactory.createAntibody("melee");
//        ab.setArea(area);
//        Virus v = UnitFactory.createVirus("melee");
//        v.setArea(area);
//        area.addAntibody(ab); area.addVirus(v);
//    }


}
