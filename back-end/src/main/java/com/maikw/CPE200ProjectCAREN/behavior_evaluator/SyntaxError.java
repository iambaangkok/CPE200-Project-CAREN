package com.maikw.CPE200ProjectCAREN.behavior_evaluator;

public class SyntaxError extends Exception{
    protected String message = "";

    public SyntaxError(){}

    public SyntaxError(String str) {
        message = str;
    }

    @Override
    public String getMessage(){
        return new String(message);
    }
}
