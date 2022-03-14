package com.maikw.CPE200ProjectCAREN.apiclasses;

public class ApiData_GeneticCodeReturnData extends ApiData_Base{
    private String compiledResult = "";
    private String errorToken = "";

    public String getCompiledResult() {
        return compiledResult;
    }

    public void setCompiledResult(String compiledResult) {
        this.compiledResult = compiledResult;
    }

    public String getErrorToken() {
        return errorToken;
    }

    public void setErrorToken(String errorToken) {
        this.errorToken = errorToken;
    }
}
