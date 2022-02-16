package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.List;

public class Wave {


    protected List<Virus> area1Virus  = new ArrayList<Virus>();
    protected List<Virus> area2Virus  = new ArrayList<Virus>();
    protected List<Virus> area3Virus  = new ArrayList<Virus>();





    public Wave(){

    }


    public List<Virus> getAreaVirus(Integer number) {



        if(number == 1 ){return area1Virus;}
        else if(number == 2 ){return area2Virus;}
        else {return area3Virus;}

}
