package com.maikw.CPE200ProjectCAREN.behavior_evaluator;

import com.maikw.CPE200ProjectCAREN.Unit;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes.Node;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes.ProgramNode;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes.VariableNode;

public class BehaviorEvaluator{
    protected Tokenizer tkz;
    protected NodeFactory factory;
    protected Unit unit;

    private static final boolean DEBUG = false;

    public BehaviorEvaluator(String src, Unit unit) {
        try{
            this.tkz = new Tokenizer(src);
            factory = NodeFactory.instance();
            this.unit = unit;
        }catch(SyntaxError e){
            System.out.println(e.getMessage());
        }
    }
    
    public Node parseProgram() throws SyntaxError, UnmatchedParenthesesError{
        if(DEBUG) System.out.println("parseProgram " + tkz.peek());
        
        ProgramNode programNode = factory.createProgramNode();
        
        while(tkz.peek() != null){
            String s = tkz.peek();
            if(DEBUG) System.out.println(s);
            if(s.matches(Regex.S_OPERATOR) || s.matches(Regex.S_NUMBER) || s.matches(Regex.S_DIRECTION) || s.matches(Regex.S_SENSOR)){ /// invalid case
                tkz.consume();
                throw new SyntaxError();
            }else if(s.matches(Regex.S_RESERVEDWORD)){ /// RESERVED WORD
                if(s.matches(Regex.S_IF)){ // IF
                    programNode.addStatement(parseIf());
                }else if(s.matches(Regex.S_WHILE)){ // WHILE
                    programNode.addStatement(parseIf());
                }else if(s.matches(Regex.S_ACTION)){ // MOVE or SHOOT
                    programNode.addStatement(parseAction());
                }else if(s.matches(Regex.S_ELSE)){
                    break;
                }
            }else if(s.matches(Regex.S_VARIABLE)){ /// ASSIGNMENT
                programNode.addStatement(parseAssignment());
            }else if(s.matches(Regex.S_PARENTHESES)){ /// PARENTHESES -> BLOCKSTATEMENT
                if(s.equals("(") || s.equals(")")){
                    throw new UnmatchedParenthesesError("( or ) as statement starter");   
                }else if(s.equals("{")){
                    if(DEBUG) System.out.println("  BRACKET {");
                    tkz.consume();
                    programNode.addStatement(parseProgram());
                    if(tkz.peek().equals("}") == false){
                        throw new UnmatchedParenthesesError("missing }");
                    } tkz.consume();
                }else if(s.equals("}")){
                    break;
                }
            }else if(s.matches("\n")){
                tkz.consume();
            }else{
                throw new SyntaxError(tkz.peek());
            }
        }
        if(DEBUG) System.out.println("RETURNED parseProgram");
        return programNode;
    }

    public Node parseAssignment() throws SyntaxError{
        if(DEBUG) System.out.println("parseAssignment " + tkz.peek());
        VariableNode variableNode = parseVariable();
        tkz.consume(Regex.S_ASSIGN);
        Node expressionNode = parseExpression();

        Node assignmentNode = factory.createNode(variableNode, expressionNode);
        return assignmentNode;
    }

    public Node parseIf() throws SyntaxError{
        if(DEBUG) System.out.println("parseIf " + tkz.peek());
        tkz.consume(Regex.S_IF);
        tkz.consume("[(]");
        Node expressionNode = parseExpression();
        tkz.consume("[)]");
        tkz.consume(Regex.S_THEN);
        Node ifTrueStatementNode = parseProgram();
        tkz.consume(Regex.S_ELSE);
        Node ifFalseStatementNode = parseProgram();

        Node ifStatementNode = factory.createNode(expressionNode, ifTrueStatementNode, ifFalseStatementNode);
        return ifStatementNode;
    }

    public Node parseWhile() throws SyntaxError{
        if(DEBUG) System.out.println("parseWhile " + tkz.peek());
        tkz.consume(Regex.S_WHILE);
        tkz.consume("[(]");
        Node expressionNode = parseExpression();
        tkz.consume("[)]");
        Node statementNode = parseProgram();

        Node whileStatemeNode = factory.createNode(expressionNode, statementNode);
        return whileStatemeNode;
    }

    public Node parseAction() throws SyntaxError{
        if(DEBUG) System.out.println("parseAction " + tkz.peek());
        boolean isAttack = false;
        if(tkz.peek(Regex.S_SHOOT)){
            isAttack = true;
        }else if(tkz.peek(Regex.S_MOVE)){
            isAttack = false;
        }
        tkz.consume(Regex.S_ACTION);

        String direction = parseDirection();

        Node actionCommandNode = factory.createNode(isAttack, direction, unit);
        return actionCommandNode;
    }
    
    //Expression → Expression + Term | Expression - Term | Term
    public Node parseExpression() throws SyntaxError, EvaluationError{
        if(DEBUG) System.out.println("parseExpression " + tkz.peek());
        Node expression = parseTerm();
        while (tkz.peek().equals("+") || tkz.peek("-")) {
            String op = tkz.consume();
            Node rightTerm = parseTerm();
            if(op.equals("+")){
                expression = factory.createNode(expression, "+", rightTerm);
            }else if(op.equals("-")){
                expression = factory.createNode(expression, "-", rightTerm);
            }else{
                throw new SyntaxError("parseExpression() unpassable");        
            }
        }

        return expression;
    }

    //Term → Term * Factor | Term / Factor | Term % Factor | Factor
    public Node parseTerm() throws SyntaxError, EvaluationError{
        if(DEBUG) System.out.println("parseTerm " + tkz.peek());
        Node term = parseFactor();

        while (tkz.peek().equals("*") || tkz.peek("/") || tkz.peek("%")) {
            String op = tkz.consume();
            Node rightTerm = parseFactor();

            if(op.equals("*")){
                term = factory.createNode(term,"*",rightTerm);
            }else if(op.equals("/")){
                if(rightTerm.evaluate() != 0){
                    term = factory.createNode(term,"/",rightTerm);
                }else{
                    throw new EvaluationError("divide by zero");       
                }
            }else if(op.equals("%")){
                if(rightTerm.evaluate() != 0){
                    term = factory.createNode(term,"%",rightTerm);
                }else{
                    throw new EvaluationError("modulo by zero");       
                }
            }else{
                throw new SyntaxError("parseTerm() unpassable");        
            }
        }
        return term;
    }

    //Factor → Power ^ Factor | Power
    public Node parseFactor() throws SyntaxError, EvaluationError{
        if(DEBUG) System.out.println("parseFactor " + tkz.peek());
        Node term = parsePower();
        if(tkz.peek("^")){
            Node binArith = factory.createNode(term, "^", parseFactor());
            return binArith;
        }
//        while (tkz.peek("^")) {
//            String op = tkz.consume();
//            Node v2 = parsePower();
//
//            if(op.equals("^")){
//                term = factory.createNode(term,"*",v2);
//            }else{
//                throw new SyntaxError("parseFactor() unpassable");
//            }
//        }
        return term;
    }

    //Power → <number> | <identifier> | ( Expression ) | SensorExpression
    public Node parsePower() throws SyntaxError, EvaluationError{
        if(DEBUG) System.out.println("parsePower " + tkz.peek());
        if(tkz.peek(Regex.S_NUMBER)){
            Node numberNode = factory.createNode(Double.parseDouble(tkz.peek()));
            tkz.consume(Regex.S_NUMBER);
            return numberNode;
        }else if(tkz.peek(Regex.S_VARIABLE)){
            VariableNode variableNode = parseVariable();
            return variableNode;
        }else if(tkz.peek("(")){
            tkz.consume("(");
            Node expressionNode = parseExpression();
            tkz.consume(")");
            return expressionNode;
        }else if(tkz.peek(Regex.S_SENSOR)){
            Node sensorNode = parseSensor();
            return sensorNode;
        }else{
            throw new SyntaxError("parsePower() unpassable");
        }
    }

    //SensorExpression → virus | antibody | nearby Direction	
    public Node parseSensor() throws SyntaxError{
        if(DEBUG) System.out.println("parseSensor " + tkz.peek());
        String mode = tkz.consume();

        if(mode.matches(Regex.S_NEARBY)){
            String direction = parseDirection();
            Node sensorNode = factory.createNode(mode, direction, unit);
            return sensorNode;
        }else if(mode.matches(Regex.S_VIRUS) | mode.matches(Regex.S_ANTIBODY)){
            Node sensorNode = factory.createNode(mode, "", unit);
            return sensorNode;
        }else{
            throw new SyntaxError("parseSensor() unpassable");
        }
    }

    public String parseDirection() throws SyntaxError{
        if(DEBUG) System.out.println("parseDirection " + tkz.peek());
        String direction = tkz.peek();
        tkz.consume(Regex.S_DIRECTION);

        return direction;
    }

    public VariableNode parseVariable() throws SyntaxError{
        if(DEBUG) System.out.println("parseVariable " + tkz.peek());
        String identifier = tkz.peek();
        if(identifier.matches(Regex.S_RANDOM)){
            tkz.consume(Regex.S_RANDOM);
            
            VariableNode randomNode = factory.createRandomNumberNode();
            return randomNode;
        }
        tkz.consume(Regex.S_VARIABLE);

        VariableNode variableNode = factory.createNode(identifier, unit.getVariables());
        return variableNode;
    }
}