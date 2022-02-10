package com.maikw.CPE200ProjectCAREN.behavior_evaluator;

import java.util.regex.Pattern;

/** This class contains all regex used for generating Abstract Syntax Tree 
 *  for Project CAREN's grammar
 * 
 */
public class Regex {
    public static final String S_ALL = "[-+*/%^]|[({})]|([0-9]+[.]*[0-9]+)|([0-9]+)|move|shoot|left|right|up|down|upleft|upright|downleft|downright|if|then|else|while|virus|antibody|nearby|([[a-zA-Z]]+[[a-zA-Z0-9]]*)";

    public static final String S_VARIABLE = "[[a-zA-Z]]+[[a-zA-Z0-9]]*";

    public static final String S_NUMBER = "([0-9]+[.]*[0-9]+)|([0-9]+)";
    public static final String S_OPERATOR = "[-+*/%^]";
    public static final String S_PARENTHESES = "[({})]";
    public static final String S_RESERVEDWORD = "move|shoot|left|right|up|down|upleft|upright|downleft|downright|if|then|else|while|virus|antibody|nearby";
    
    public static final String S_DIRECTION = "left|right|up|down|upleft|upright|downleft|downright";
    public static final String S_LEFT = "left";
    public static final String S_RIGHT = "right";
    public static final String S_UP = "up";
    public static final String S_DOWN = "down";
    public static final String S_UPLEFT = "upleft";
    public static final String S_UPRIGHT = "upright";
    public static final String S_DOWNLEFT = "downleft";
    public static final String S_DOWNRIGHT = "downright";

    public static final String S_SENSOR = "virus|antibody|nearby";
    public static final String S_VIRUS = "virus";
    public static final String S_ANTIBODY = "antibody";
    public static final String S_NEARBY = "nearby";
    
    public static final String S_MOVE = "move";
    public static final String S_SHOOT = "shoot";
    
    public static final String S_IF = "if";
    public static final String S_THEN = "then";
    public static final String S_ELSE = "else";

    public static final String S_WHILE = "while";

    public static final Pattern ALL = Pattern.compile(S_ALL);

    public static final Pattern VARIABLE = Pattern.compile(S_VARIABLE);

    public static final Pattern NUMBER = Pattern.compile(S_NUMBER);
    public static final Pattern OPERATOR = Pattern.compile(S_OPERATOR);
    public static final Pattern PARENTHESES = Pattern.compile(S_PARENTHESES);
    public static final Pattern RESERVEDWORD = Pattern.compile(S_RESERVEDWORD);
    
    public static final Pattern DIRECTION = Pattern.compile(S_DIRECTION);
    public static final Pattern LEFT = Pattern.compile(S_LEFT);
    public static final Pattern RIGHT = Pattern.compile(S_RIGHT);
    public static final Pattern UP = Pattern.compile(S_UP);
    public static final Pattern DOWN = Pattern.compile(S_DOWN);
    public static final Pattern UPLEFT = Pattern.compile(S_UPLEFT);
    public static final Pattern UPRIGHT = Pattern.compile(S_UPRIGHT);
    public static final Pattern DOWNLEFT = Pattern.compile(S_DOWNLEFT);
    public static final Pattern DOWNRIGHT = Pattern.compile(S_DOWNRIGHT);

    public static final Pattern SENSOR = Pattern.compile(S_SENSOR);
    public static final Pattern VIRUS = Pattern.compile(S_VIRUS);
    public static final Pattern ANTIBODY = Pattern.compile(S_ANTIBODY);
    public static final Pattern NEARBY = Pattern.compile(S_NEARBY);
    
    public static final Pattern MOVE = Pattern.compile(S_MOVE);
    public static final Pattern SHOOT = Pattern.compile(S_SHOOT);
    
    public static final Pattern IF = Pattern.compile(S_IF);
    public static final Pattern THEN = Pattern.compile(S_THEN);
    public static final Pattern ELSE = Pattern.compile(S_ELSE);

    public static final Pattern WHILE = Pattern.compile(S_WHILE);
}
