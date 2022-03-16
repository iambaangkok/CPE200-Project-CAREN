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
        Unit unitMelee = UnitFactory.createDummy("melee");
        Unit unitRanged = UnitFactory.createDummy("ranged");
        Unit unitAoe = UnitFactory.createDummy("aoe");

        // melee move speed -> 3

        // up

        // upright

        // right

        // downright

        // down

        // downleft

        // left

        // upleft


        // ranged move speed -> 2

        // up

        // upright

        // right

        // downright

        // down

        // downleft

        // left

        // upleft




        // aoe move speed -> 1

        // up

        // upright

        // right

        // downright

        // down

        // downleft

        // left

        // upleft




    }

    @Test
    void attackDirection() {
        Config.readFile("config/config_0.txt");
        Antibody ab_melee = UnitFactory.createAntibody("melee"); ab_melee.setPositionX(0); ab_melee.setPositionY(1); ab_melee.setArea(area);
        Antibody ab_ranged = UnitFactory.createAntibody("ranged"); ab_ranged.setPositionX(-20); ab_ranged.setPositionY(-20); ab_ranged.setArea(area);
        Antibody ab_aoe = UnitFactory.createAntibody("aoe"); ab_aoe.setPositionX(0); ab_aoe.setPositionY(10); ab_aoe.setArea(area);
        Virus v_melee = UnitFactory.createVirus("melee"); v_melee.setPositionX(5); v_melee.setPositionY(10); v_melee.setArea(area);
        Virus v_ranged = UnitFactory.createVirus("ranged"); v_ranged.setPositionX(-3); v_ranged.setPositionY(1); v_ranged.setArea(area);
        Virus v_aoe = UnitFactory.createVirus("aoe"); v_aoe.setPositionX(-20); v_aoe.setPositionY(-25); v_aoe.setArea(area);
        area.addAntibody(ab_melee); area.addAntibody(ab_ranged); area.addAntibody(ab_aoe);
        area.addVirus(v_melee); area.addVirus(v_ranged); area.addVirus(v_aoe);

        // melee attack -> attack range = 10, dmg = 20
        ab_melee.attack("left"); // can attack -> ab_melee attack v_ranged
        System.out.println(v_ranged.getCurrentHealth() + " " + (v_ranged.getMaxHealth() - ab_melee.getAttackDamage()));
        assertEquals(v_ranged.getCurrentHealth(), v_ranged.getMaxHealth() - ab_melee.getAttackDamage());
        ab_melee.attack("downright"); // can't attack -> nothing happen

        // ranged attack -> attack range = 30, dmg = 20
        ab_ranged.attack("down"); // can attack -> ab_ranged attack v_aoe
        assertEquals(v_aoe.getCurrentHealth(), v_aoe.getMaxHealth() - ab_ranged.getAttackDamage());
        ab_ranged.attack("left"); // can't attack -> nothing happen

        // aoe attack -> attack range = 20, dmg = 15
        ab_aoe.attack("right"); // can attack -> ab_aoe attack v_melee
        assertEquals(v_melee.getCurrentHealth(), v_melee.getMaxHealth() - ab_aoe.getAttackDamage());
        ab_aoe.attack("upleft"); // can't attack -> nothing happen

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
        assertEquals(Unit.directionValue(85.346309,""), 1);
        assertEquals(Unit.directionValue(90,""), 1);
        assertEquals(Unit.directionValue(112.4999997,""), 1);

        assertEquals(Unit.directionValue(25.23857903,""), 2);
        assertEquals(Unit.directionValue(45,""), 2);
        assertEquals(Unit.directionValue(67.49389239,""), 2);

        assertEquals(Unit.directionValue(360, ""), 3);
        assertEquals(Unit.directionValue(0, ""), 3);
        assertEquals(Unit.directionValue(22.436070, ""), 3);
        assertEquals(Unit.directionValue(359.304596, ""), 3);

        assertEquals(Unit.directionValue(292.5435623456,""), 4);
        assertEquals(Unit.directionValue(315,""), 4);
        assertEquals(Unit.directionValue(335.23500897,""), 4);

        assertEquals(Unit.directionValue(247.623412, ""), 5);
        assertEquals(Unit.directionValue(270, ""), 5);
        assertEquals(Unit.directionValue(292.23456028, ""), 5);

        assertEquals(Unit.directionValue(202.6134532, ""), 6);
        assertEquals(Unit.directionValue(225, ""), 6);
        assertEquals(Unit.directionValue(247.49586, ""), 6);

        assertEquals(Unit.directionValue(159.4902, ""), 7);
        assertEquals(Unit.directionValue(180, ""), 7);
        assertEquals(Unit.directionValue(200.1354235, ""), 7);

        assertEquals(Unit.directionValue(112.5456 , ""), 8);
        assertEquals(Unit.directionValue(135, ""), 8);
        assertEquals(Unit.directionValue(150.2435, ""), 8);

        assertEquals(Unit.directionValue(0, "up"), 1);
        assertEquals(Unit.directionValue(0, "upright"), 2);
        assertEquals(Unit.directionValue(0, "right"), 3);
        assertEquals(Unit.directionValue(0, "downright"), 4);
        assertEquals(Unit.directionValue(0, "down"), 5);
        assertEquals(Unit.directionValue(0, "downleft"), 6);
        assertEquals(Unit.directionValue(0, "left"), 7);
        assertEquals(Unit.directionValue(0, "upleft"), 8);

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
