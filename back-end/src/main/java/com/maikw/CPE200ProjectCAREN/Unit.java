package com.maikw.CPE200ProjectCAREN;

import java.util.*;

import com.maikw.CPE200ProjectCAREN.behavior_evaluator.BehaviorEvaluator;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.SyntaxError;
import com.maikw.CPE200ProjectCAREN.behavior_evaluator.nodes.Node;

public class Unit {

    protected double positionX = 0.0;
    protected double positionY = 0.0;
    protected int maxHealth = 100;
    protected int currentHealth = 100;
    protected int moveCost = 20;
    protected int moveSpeed;
    protected int attackDamage;
    protected double detectRange;
    protected double attackRange;
    protected double aoeRadius;
    protected double dangerRange;
    protected int lifeSteal = 10;
    protected String type;
    protected String name;
    protected Map<String, Double> variables;
    public Node programNode;
    protected Area area;
    protected String unitClass;
    protected boolean didActionCommand = false;

    public Unit(String name, String type, String geneticCode){
        variables = new HashMap<>();
        this.name = name;
        this.type = type;
        this.detectRange = 40;
        this.dangerRange = 5;
        this.aoeRadius = 0;
        switch (type) {
            case "melee" -> {
                this.attackDamage = 20;
                this.attackRange = 10;
                this.moveSpeed = 3;
            }
            case "ranged" -> {
                this.attackDamage = 20;
                this.attackRange = 30;
                this.moveSpeed = 2;
            }
            case "aoe" -> {
                this.attackDamage = 15;
                this.attackRange = 10;
                this.aoeRadius = 5;
                this.moveSpeed = 1;
            }
        }
        BehaviorEvaluator be = new BehaviorEvaluator(geneticCode,this);
        try{
            programNode = be.parseProgram();
        }catch(SyntaxError e){
            System.out.println("parse error: " + e.getMessage() + " " +e.getMessage().length());
            e.printStackTrace();
        }
    }

    public void move(String direction){
        if (sense("nearby", direction) == 0){
            positionEval(direction);
            System.out.println("Unit " + name + " moved " + direction);
        }else{
            System.out.println("There is already a unit there. Unit " + name + " can't move to " + direction);
        }
    }

    public void attack(String direction){
        String targetClass = "";
        if(this.unitClass.equals("virus")) targetClass = "antibody";
        else if(this.unitClass.equals("antibody")) targetClass = "virus";
        attackEval(targetClass, direction);
        System.out.println("Unit " + name + " attacked " + direction);
    }

    public void attack(Unit target){
        target.takeDamage(attackDamage);
        System.out.println("Unit " + target.name + "received damage current hp = " + target.currentHealth);
    }

    public void takeDamage(int dmg){
        if(this.currentHealth <= dmg){
            this.currentHealth = 0;
        }else{
            this.currentHealth -= dmg;
        }
    }

    public int sense(String mode, String direction){
        System.out.println("Unit " + name + " sensed " + mode + " " + direction);
        switch (mode) {
            case "virus" -> {
                return senseEval("virus");
            }
            case "antibody" -> {
                return senseEval("antibody");
            }
            case "nearby" -> {
                return senseUnitEval(area.getUnits(), direction);
            }
        }
        return 0;
    }

    public static double range(Unit a, Unit b){
        return Math.sqrt(Math.pow((a.positionX - b.positionX),2) + Math.pow((a.positionY - b.positionY),2));
    }

    private void positionEval(String direction){
        switch (direction) {
            case "up" -> this.positionY += moveSpeed;
            case "upright" -> {
                this.positionX += moveSpeed;
                this.positionY += moveSpeed;
            }
            case "right" -> this.positionX += moveSpeed;
            case "downright" -> {
                this.positionX += moveSpeed;
                this.positionY -= moveSpeed;
            }
            case "down" -> this.positionY -= moveSpeed;
            case "downleft" -> {
                this.positionX -= moveSpeed;
                this.positionY -= moveSpeed;
            }
            case "left" -> this.positionX -= moveSpeed;
            case "upleft" -> {
                this.positionX -= moveSpeed;
                this.positionY += moveSpeed;
            }
        }

    }

    public static double getAngle(Unit a, Unit b){
        double angle = Math.toDegrees(Math.atan2(b.positionY - a.positionY, b.positionX - a.positionX));

        if (angle < 0) {
            angle += 360;
        }

        return angle;
    }

    public static int directionValue(double angle, String direction){
        if(direction.equals("")){
            if(angle >= (90-22.5) && angle <= (90+22.5)){
                return 1;
            }else if(angle >= (45-22.5) && angle <= (45+22.5)){
                return 2;
            }else if((angle >= (360-22.5) && angle <= (360)) || (angle >= 0.0 && angle <= 22.5)){
                return 3;
            }else if(angle >= (315-22.5) && angle <= (315+22.5)){
                return 4;
            }else if(angle >= (270-22.5) && angle <= (270+22.5)){
                return 5;
            }else if(angle >= (225-22.5) && angle <= (225+22.5)){
                return 6;
            }else if(angle >= (180-22.5) && angle <= (180+22.5)){
                return 7;
            }else if(angle >= (135-22.5) && angle <= (135+22.5)){
                return 8;
            }else{
                return 0;
            }
        }else{
            return switch (direction) {
                case "up" -> 1;
                case "upright" -> 2;
                case "right" -> 3;
                case "downright" -> 4;
                case "down" -> 5;
                case "downleft" -> 6;
                case "left" -> 7;
                case "upleft" -> 8;
                default -> 0;
            };
        }

    }

    public static int directionConverter(String direction){
        return switch (direction) {
            case "up" -> 90;
            case "upright" -> 45;
            case "right" -> 0;
            case "downright" -> 315;
            case "down" -> 270;
            case "downleft" -> 225;
            case "left" -> 180;
            case "upleft" -> 135;
            default -> 0;
        };
    }

    public void attackEval(String targetUnit, String direction){
        Unit target = findClosestUnit(targetUnit);
        if(findClosestUnit(targetUnit) != null){
            double range = range(this, target);
            double angle = getAngle(this, target);
            int directionAngle = directionConverter(direction);
            if(range < attackRange && angle >= (directionAngle-22.5) && angle <= (directionAngle+22.5)){
                this.attack(target);
                if(this.type.equals("aoe")){
                    List<Unit> units = this.area.getUnits();
                    for(Unit u : units){
                        range = range(target,u);
                        if(range <= this.aoeRadius){
                            if(!u.getName().equals(this.name)){
                                attack(u);
                            }
                        }
                    }
                }
            }
        }else{
            System.out.println("Can't attack, No Unit nearby.");
        }

    }

    private int senseEval(String classUnit){
        Unit closestUnit = findClosestUnit(classUnit);
        double angle = getAngle(this, closestUnit);
        int directionAngle = directionValue(angle, "");
        double min = range(this,closestUnit);
        if (min <= dangerRange) {
            return 10  + directionAngle;
        } else if (min <= attackRange) {
            return 20 + directionAngle;
        } else if (min <= detectRange) {
            return 30 + directionAngle;
        }
        return 0;
    }

    private int senseUnitEval(List<Unit> units, String direction){
        double min = Integer.MAX_VALUE;
        int baseDirectionValue = directionValue(0, direction);
        String classUnit = "";
        for (Unit u : units) {
            double angle = getAngle(this, u);
            int directionValue = directionValue(angle,"");
            double range = range(this, u);
            if (directionValue != baseDirectionValue) {
            }else{
                if (this.detectRange < range) {
                } else {
                    if (range < min) {
                        min = range;
                        classUnit = u.getUnitClass();
                    }
                }
            }
        }

        int classValue = 0;
        if(classUnit.equals("virus")){
            classValue = 1;
        }else if(classUnit.equals("antibody")){
            classValue = 2;
        }

        if (min == Integer.MAX_VALUE) {
            return 0;
        } else if (min <= dangerRange) {
            return 10 + classValue;
        } else if (min <= attackRange) {
            return 20 + classValue;
        } else if (min <= detectRange) {
            return 30 + classValue;
        }
        return 0;
    }

    public Unit findClosestUnit(String classUnit){
        Unit closestUnit = null;
        List<? extends Unit> units = null;
        if(classUnit.equals("virus")){
            units = this.area.getViruses();
        }else if(classUnit.equals("antibody")){
            units = this.area.getAntibodies();
        }else if(classUnit.equals("all")){
            units = this.area.getUnits();
        }
        double min = Integer.MAX_VALUE;
        for (Unit u : units) {
            double range = range(this, u);
            if (this.detectRange > range) {
                if (range < min){
                    min = range;
                    closestUnit = u;
                }
            }
        }
        return closestUnit;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public Area getArea() {
        return area;
    }

    public boolean isAlive(){
        return currentHealth <= 0;
    }

    public Map<String, Double> getVariables(){
        return variables;
    }


    public void evaluate(){
        programNode.evaluate();
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMoveCost() {
        return moveCost;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public double getDetectRange() {
        return detectRange;
    }

    public double getDangerRange() {
        return dangerRange;
    }

    public double getAttackRange() {
        return attackRange;
    }

    public int getLifeSteal() {
        return lifeSteal;
    }

    public String getUnitClass() {
        return unitClass;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public boolean getDidActionCommand(){
        return didActionCommand;
    }

    public void setDidActionCommand(boolean state){
        this.didActionCommand = state;
    }

}
