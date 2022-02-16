package com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes;

public interface Node {

    /** Evaluate the node according to the node type
     *  @effects may vary according to the node type
     *  @returns the result of the evaluation as floating point number, 
     *  if the node doesn't need to return anything, 0 is returned
     * 
     */
    public double evaluate();
    public void print(int depth);
}
