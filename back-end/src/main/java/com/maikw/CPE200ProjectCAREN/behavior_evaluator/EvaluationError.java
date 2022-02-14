package com.maikw.CPE200ProjectCAREN.behavior_evaluator;

public class EvaluationError extends SyntaxError{
    public EvaluationError(){}

    public EvaluationError(String str) {
        message = str;
    }
}
