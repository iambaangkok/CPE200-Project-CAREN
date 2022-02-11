package com.maikw.CPE200ProjectCAREN.behavior_evaluator;

public class UnmatchedParenthesesError extends SyntaxError{
    public UnmatchedParenthesesError(){}

    public UnmatchedParenthesesError(String str) {
        message = str;
    }
}
