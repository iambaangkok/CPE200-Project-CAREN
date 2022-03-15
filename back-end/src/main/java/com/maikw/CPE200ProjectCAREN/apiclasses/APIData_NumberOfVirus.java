package com.maikw.CPE200ProjectCAREN.apiclasses;

public class APIData_NumberOfVirus   {

    public int waveNumber;
    public APIData_Area area1;
    public APIData_Area area2;
    public APIData_Area area3;


    public int getWaveNumber() {
        return waveNumber;
    }

    public void setWaveNumber(int waveNumber) {
        this.waveNumber = waveNumber;
    }

    public APIData_Area getArea1() {
        return area1;
    }

    public void setArea1(APIData_Area area1) {
        this.area1 = area1;
    }

    public APIData_Area getArea2() {
        return area2;
    }

    public void setArea2(APIData_Area area2) {
        this.area2 = area2;
    }

    public APIData_Area getArea3() {
        return area3;
    }

    public void setArea3(APIData_Area area3) {
        this.area3 = area3;
    }
}
