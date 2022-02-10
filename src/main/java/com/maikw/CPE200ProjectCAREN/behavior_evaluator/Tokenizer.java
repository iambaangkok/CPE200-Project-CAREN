package com.maikw.CPE200ProjectCAREN.behavior_evaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Tokenizer{

    
    protected String geneticCode;
    protected List<String> tokens;
    protected String next;
    
    protected Matcher matcher;

    public Tokenizer(String geneticCode) throws SyntaxError {
        this.geneticCode = geneticCode;
        tokens = new ArrayList<>();
        
        matcher = Regex.ALL.matcher(geneticCode);
        
        computeNext();
    }
 
    private void computeNext() throws SyntaxError {
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
    public String consume() throws SyntaxError {
        String result = next;
        computeNext();

        return result;
    }

    /**
     * Returns true if
     * the next token is s.
     */
    boolean peek(String s) {
        return peek().equals(s);
    }

    /**
     * Consume the next token if it is s.
     * Throw SyntaxError otherwise.
     */
    void consume(String s) throws SyntaxError {
        if (peek(s)) {
            consume();
        } else {
            throw new SyntaxError("consume(s): token does not match s");
        }
    }
}
