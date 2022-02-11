package com.maikw.CPE200ProjectCAREN.behavior_evaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Tokenizer{

    
    protected String geneticCode;
    protected List<String> tokens;
    protected String next;
    
    protected Matcher matcher;

    private static final boolean DEBUG = true;

    public Tokenizer(String geneticCode) throws SyntaxError {
        this.geneticCode = geneticCode;
        tokens = new ArrayList<>();
        
        matcher = Regex.P_ALL.matcher(geneticCode);

        System.out.println("geneticCode: " + geneticCode);
        
        computeNext();
    }
 
    private void computeNext(){
        if(matcher.find()){
            next = matcher.group();
        }else{
            next = null;
        }
    }

    /** Returns the next token
    *  in the input stream. */
    public String peek() {
        return next;
    }

    /** Consumes the next token
     *  from the input stream
     *  and returns it. */
    public String consume(){
        String result = next;
        computeNext();

        return result;
    }

    /**
     *  Returns true if
     *  the next token matches the regex.
     *  @param regex
     */
    boolean peek(String regex) {
        return peek().matches(regex);
    }

    /**
     *  Consume the next token if it matches the regex.
     *  Throw SyntaxError otherwise.
     *  @param regex
     */
    void consume(String regex) throws SyntaxError {
        if (peek().matches(regex)) {
            consume();
        } else {
            throw new SyntaxError("consume(s): token does not match s");
        }
    }
}
