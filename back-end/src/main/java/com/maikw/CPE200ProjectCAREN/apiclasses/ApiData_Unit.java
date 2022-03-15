package com.maikw.CPE200ProjectCAREN.apiclasses;

import com.maikw.CPE200ProjectCAREN.Unit;

public class ApiData_Unit extends ApiData_Base{
    String name;

    public String getUnitName() {
        return name;
    }

    public void setUnit(String name) {
        this.name = name;
    }
}
