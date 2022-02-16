package com.maikw.CPE200ProjectCAREN;

import java.util.ArrayList;
import java.util.List;

public class Wave {
    protected List<Virus> area1Virus;
    protected List<Virus> area2Virus;
    protected List<Virus> area3Virus;
    protected int waveNumber;

    public Wave(int waveNumber) {
        this.area1Virus = new ArrayList<Virus>();
        this.area2Virus = new ArrayList<Virus>();
        this.area3Virus = new ArrayList<Virus>();
        this.waveNumber = waveNumber;
    }

    public List<Virus> getAreaVirus(Integer number) {
        if (number == 1) {
            return area1Virus;
        } else if (number == 2) {
            return area2Virus;
        } else {
            return area3Virus;
        }
    }
}