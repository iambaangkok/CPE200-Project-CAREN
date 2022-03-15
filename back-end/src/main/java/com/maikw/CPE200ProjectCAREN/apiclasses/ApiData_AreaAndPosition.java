package com.maikw.CPE200ProjectCAREN.apiclasses;

import com.maikw.CPE200ProjectCAREN.Area;

public class ApiData_AreaAndPosition extends ApiData_Base{
    int area; // Area Number
    String type;
    double PositionX;
    double PositionY;

    public int getArea() { // Area Number
        return area;
    }

    public void setArea(int area) { // Area Number
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPositionX() {
        return PositionX;
    }

    public void setPositionX(double positionX) {
        PositionX = positionX;
    }

    public double getPositionY() {
        return PositionY;
    }

    public void setPositionY(double positionY) {
        PositionY = positionY;
    }
}
