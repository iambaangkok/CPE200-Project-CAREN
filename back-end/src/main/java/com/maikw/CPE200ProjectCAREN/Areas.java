package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;

import java.util.List;

public class Areas extends Area{

    protected List<Area> allAreas  = new ArrayList<Area>();


    public Areas(){

    }

    public void add(Area a){
        allAreas.add(a);
    }


    public void showAllAreas(){ System.out.println(allAreas); }

    public Area selectArea(Integer n){

     return  allAreas.get(n);
    }


}
