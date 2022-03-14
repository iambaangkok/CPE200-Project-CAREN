package com.maikw.CPE200ProjectCAREN;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AreaTest {
    Area area = new Area("Area1");
    Antibody[] abs_melee = {UnitFactory.createAntibody("melee"),UnitFactory.createAntibody("melee"),UnitFactory.createAntibody("melee")};
    Antibody[] abs_ranged = {UnitFactory.createAntibody("ranged"),UnitFactory.createAntibody("ranged"),UnitFactory.createAntibody("ranged")};
    Antibody[] abs_aoe = {UnitFactory.createAntibody("aoe"),UnitFactory.createAntibody("aoe"),UnitFactory.createAntibody("aoe")};
    Virus[] vs_melee = {UnitFactory.createVirus("melee"),UnitFactory.createVirus("melee"),UnitFactory.createVirus("melee")};
    Virus[] vs_ranged = {UnitFactory.createVirus("ranged"),UnitFactory.createVirus("ranged"),UnitFactory.createVirus("ranged")};
    Virus[] vs_aoe = {UnitFactory.createVirus("aoe"),UnitFactory.createVirus("aoe"),UnitFactory.createVirus("aoe")};
    List<Virus> viruses = new ArrayList<Virus>();
    List<Antibody> antibodies = new ArrayList<Antibody>();

    @Test
    void addVirus() {
        for(int i = 0 ; i < 3 ; i++){
            area.addVirus(vs_melee[i]);
            assertEquals(vs_melee[i].getArea(),area);
            area.addVirus(vs_ranged[i]);
            assertEquals(vs_ranged[i].getArea(),area);
            area.addVirus(vs_aoe[i]);
            assertEquals(vs_aoe[i].getArea(),area);
        }
        assertEquals(area.viruses.size(),9);
    }

    @Test
    void addAllVirus() {
        for(int i = 0; i < 3 ; i++){
            viruses.add(vs_melee[i]);
            viruses.add(vs_ranged[i]);
            viruses.add(vs_aoe[i]);
        }
        area.addAllVirus(viruses);
        assertEquals(area.getViruses(),viruses);
    }

    @Test
    void addAntibody() {
    }

    @Test
    void addAllAntibody() {
    }

    @Test
    void removeVirus() {
    }

    @Test
    void removeAntibody() {
    }

    @Test
    void alertLevel() {
    }

    @Test
    void canPlace() {
    }

    @Test
    void isTaken() {
    }

    @Test
    void snapViruses() {
    }
}
