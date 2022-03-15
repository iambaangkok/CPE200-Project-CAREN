package com.maikw.CPE200ProjectCAREN;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {
    Area area = new Area("Area1");
    Antibody[] abs_melee = {UnitFactory.createAntibody("melee"),UnitFactory.createAntibody("melee"),UnitFactory.createAntibody("melee")};
    Antibody[] abs_ranged = {UnitFactory.createAntibody("ranged"),UnitFactory.createAntibody("ranged"),UnitFactory.createAntibody("ranged")};
    Antibody[] abs_aoe = {UnitFactory.createAntibody("aoe"),UnitFactory.createAntibody("aoe"),UnitFactory.createAntibody("aoe")};
    Virus[] vs_melee = {UnitFactory.createVirus("melee"),UnitFactory.createVirus("melee"),UnitFactory.createVirus("melee")};
    Virus[] vs_ranged = {UnitFactory.createVirus("ranged"),UnitFactory.createVirus("ranged"),UnitFactory.createVirus("ranged")};
    Virus[] vs_aoe = {UnitFactory.createVirus("aoe"),UnitFactory.createVirus("aoe"),UnitFactory.createVirus("aoe")};
    List<Virus> viruses = new ArrayList<Virus>();
    List<Antibody> antibodies = new ArrayList<Antibody>();
    List<Unit> units = new ArrayList<Unit>();

    @Test
    void move() {
        // melee move speed -> 3


        // ranged move speed -> 2


        // aoe move speed -> 1


    }

    @Test
    void attackDirection() {
        Antibody ab_melee = abs_melee[1];
        Antibody ab_ranged = abs_ranged[1];
        Antibody ab_aoe = abs_aoe[1];
        Virus v_melee = vs_melee[1];
        Virus v_ranged = vs_ranged[1];
        Virus v_aoe = vs_aoe[1];

        // melee attack -> attack range = 10, dmg = 20


        // ranged attack -> attack range = 30, dmg = 20


        // aoe attack -> attack range = 20, dmg = 15


    }

    @Test
    void attackTarget() {
        Antibody ab_melee = abs_melee[0];
        Antibody ab_ranged = abs_ranged[0];
        Antibody ab_aoe = abs_aoe[0];
        Virus v_melee = vs_melee[0];
        Virus v_ranged = vs_ranged[0];
        Virus v_aoe = vs_aoe[0];
        // melee attack -> attack range = 10, dmg = 20
        ab_melee.attack(v_melee);
        assertEquals(v_melee.getCurrentHealth(), v_melee.getMaxHealth() - ab_melee.getAttackDamage());
        ab_melee.attack(ab_melee);
        assertEquals(ab_melee.getCurrentHealth(), ab_melee.getMaxHealth() - v_melee.getAttackDamage());
        
        // ranged attack -> attack range = 30, dmg = 20
        ab_ranged.attack(v_ranged);
        assertEquals(v_ranged.getCurrentHealth(), v_ranged.getMaxHealth() - ab_ranged.getAttackDamage());
        ab_ranged.attack(ab_ranged);
        assertEquals(ab_ranged.getCurrentHealth(), ab_ranged.getMaxHealth() - v_ranged.getAttackDamage());

        // aoe attack -> attack range = 20, dmg = 15
        ab_aoe.attack(v_aoe);
        assertEquals(v_aoe.getCurrentHealth(), v_aoe.getMaxHealth() - ab_aoe.getAttackDamage());
        ab_aoe.attack(ab_aoe);
        assertEquals(ab_aoe.getCurrentHealth(), ab_aoe.getMaxHealth() - v_aoe.getAttackDamage());
    }

    @Test
    void takeDamage() {
        // create dummy unit for testing
        Unit unit = UnitFactory.createDummy("melee");

        // check max health (100)
        assertEquals(unit.getMaxHealth(), 100);

        // take damage
        unit.takeDamage(1);
        assertEquals(unit.getCurrentHealth(), unit.getMaxHealth() - 1); // check health (99)
        unit.takeDamage(50);
        assertEquals(unit.getCurrentHealth(), unit.getMaxHealth() - 51); // check helath (49)
        unit.takeDamage(-999); // don't receive damage
        assertEquals(unit.getCurrentHealth(), unit.getMaxHealth() - 51); // check helath (49)
        unit.takeDamage(100); // unit is dead
        assertFalse(unit.isAlive());
    }

    @Test
    void sense() {
    }

    @Test
    void range() { // formula is Math.sqrt(Math.pow((a.positionX - b.positionX),2) + Math.pow((a.positionY - b.positionY),2))
        // position of virus is always random so if we use method range() to find range it must equal this formula
        Virus a = UnitFactory.createVirus("melee");
        Virus b = UnitFactory.createVirus("ranged");
        Virus c = UnitFactory.createVirus("aoe");
        assertEquals(Unit.range(a, b), Math.sqrt(Math.pow((a.positionX - b.positionX),2) + Math.pow((a.positionY - b.positionY),2)));
        assertEquals(Unit.range(a, c), Math.sqrt(Math.pow((a.positionX - c.positionX),2) + Math.pow((a.positionY - c.positionY),2)));
        assertEquals(Unit.range(b, c), Math.sqrt(Math.pow((b.positionX - c.positionX),2) + Math.pow((b.positionY - c.positionY),2)));
    }

    @Test
    void directionValue() {
        assertEquals(Unit.directionValue(85.346309,"up"), 1);
        assertEquals(Unit.directionValue(90,"up"), 1);
        assertEquals(Unit.directionValue(112.4999997,"up"), 1);

        assertEquals(Unit.directionValue(25.23857903,"upright"), 2);
        assertEquals(Unit.directionValue(45,"upright"), 2);
        assertEquals(Unit.directionValue(67.49389239,"upright"), 2);

        assertEquals(Unit.directionValue(360, "right"), 3);
        assertEquals(Unit.directionValue(0, "right"), 3);
        assertEquals(Unit.directionValue(22.436070, "right"), 3);
        assertEquals(Unit.directionValue(359.304596, "right"), 3);

        assertEquals(Unit.directionValue(292.5435623456,"downright"), 4);
        assertEquals(Unit.directionValue(315,"downright"), 4);
        assertEquals(Unit.directionValue(335.23500897,"downright"), 4);

        assertEquals(Unit.directionValue(247.523412, "down"), 5);
        assertEquals(Unit.directionValue(270, "down"), 5);
        assertEquals(Unit.directionValue(292.23456028, "down"), 5);

        assertEquals(Unit.directionValue(202.5134532, "downleft"), 6);
        assertEquals(Unit.directionValue(225, "downleft"), 6);
        assertEquals(Unit.directionValue(247.5, "downleft"), 6);

        assertEquals(Unit.directionValue(159.4902, "left"), 7);
        assertEquals(Unit.directionValue(180, "left"), 7);
        assertEquals(Unit.directionValue(200.1354235, "left"), 7);

        assertEquals(Unit.directionValue(112.5456 , "upleft"), 8);
        assertEquals(Unit.directionValue(135, "upleft"), 8);
        assertEquals(Unit.directionValue(150.2435, "upleft"), 8);

    }

    @Test
    void directionConverter() {
        assertEquals(Unit.directionConverter("up"), 90);
        assertEquals(Unit.directionConverter("upright"), 45);
        assertEquals(Unit.directionConverter("right"), 0);
        assertEquals(Unit.directionConverter("downright"), 315);
        assertEquals(Unit.directionConverter("down"), 270);
        assertEquals(Unit.directionConverter("downleft"), 225);
        assertEquals(Unit.directionConverter("left"), 180);
        assertEquals(Unit.directionConverter("upleft"), 135);
    }

    @Test
    void attackEval() {
    }

    @Test
    void findClosestUnit() {
    }

    @Test
    void findClosestUnitDirection() {

    }

    @Test
    void isAlive() {
        Unit unit = UnitFactory.createDummy("melee");
        assertTrue(unit.isAlive()); // unit is alive
        unit.takeDamage(150);
        assertFalse(unit.isAlive()); // unit is dead
    }
}
