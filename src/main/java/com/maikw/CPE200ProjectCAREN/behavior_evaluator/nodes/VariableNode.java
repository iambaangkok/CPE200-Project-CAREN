package com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes;

import java.util.Map;

public class VariableNode implements Node{
    protected Map<String,Double> variables = null;
    protected String identifier;

    public VariableNode(String identifier, Map<String,Double> variables){
        this.variables = variables;
        this.identifier = identifier;
        if(!variables.keySet().contains(identifier)){
            variables.put(identifier, 0.0);
        }
    }

    @Override
    public double evaluate() {
        if(!variables.keySet().contains(identifier)){
            variables.put(identifier, 0.0);
        }
        return variables.get(identifier);
    }

    /** Assign the value to the variable {@code identifier}
     * 
     * @param value the value to be assigned
     */
    public void assignValue(double value){
        variables.put(identifier, value);
    }

    public String getIdentifier(){
        return getIdentifier();
    }
}
