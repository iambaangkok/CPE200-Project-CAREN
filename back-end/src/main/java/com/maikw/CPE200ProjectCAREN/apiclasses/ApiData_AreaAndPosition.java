package com.maikw.CPE200ProjectCAREN.apiclasses;

public class ApiData_AreaAndPosition extends ApiData_Base{
    private int area; // Area Number
    private String type;
    private double positionX;
    private double positionY;

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
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }
}
