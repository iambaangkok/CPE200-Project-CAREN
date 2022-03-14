package com.maikw.CPE200ProjectCAREN.apiclasses;

public class ApiData_GeneticCodeUpload extends ApiData_Base{
    public String type;
    public String geneticCode;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGeneticCode() {
        return geneticCode;
    }

    public void setGeneticCode(String geneticCode) {
        this.geneticCode = geneticCode;
    }
}
